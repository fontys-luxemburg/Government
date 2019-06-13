package government.controller;

import government.Urls;
import government.annotation.PropertiesFromFile;
import government.annotation.Secured;
import government.dto.OwnershipDto;
import government.dto.UserDto;
import government.facade.JwtFacade;
import government.facade.OwnershipFacade;
import government.facade.UserFacade;
import government.mapper.OwnershipMapper;
import government.mapper.UserMapper;
import government.model.*;
import org.apache.commons.lang.RandomStringUtils;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;


@Path("/users")
@Produces("application/json")
@Consumes("application/json")
public class UsersController {

    @Inject
    UserFacade userFacade;
    @Inject
    OwnershipFacade ownershipFacade;
    @Inject
    JwtFacade jwt;

    @Inject
    UserMapper userMapper;
    @Inject
    OwnershipMapper ownershipMapper;
    @Context
    SecurityContext context;
    @Inject
    @PropertiesFromFile
    Properties props;

    @GET
    @Secured
    public Response index(@QueryParam("search") String searchTerm) {
        if(searchTerm == null) {
            return Response.ok().build();
        }

        return Response.ok(userFacade.search(searchTerm)).build();
    }

    @POST
    public Response create(User user) {
        User savedUser = userFacade.save(user);

        return Response.ok(new AuthResponse(savedUser, jwt.issueToken(savedUser.getEmail()))).build();
    }

    @POST
    @Path("driver")
    public Response createDriver(UserDto userDto){
        String password = RandomStringUtils.random(20,true,true);
        User user = userMapper.userDtoToUser(userDto);
        user.setId(null);
        user.setPassword(password);
        user.setOwnerships(new ArrayList<>());
        try{
            user = userFacade.save(user);
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).build();
        }
        mailHelper.sendMailToUser(user,password);
        return Response.ok(userMapper.userToUserDto(user)).build();
    }
    @GET
    @Path("{driver_id}")
    @Secured
    public Response getDriver(@PathParam("driver_id") Long driver_id) {
        Optional<User> user = userFacade.findById(driver_id);

        if (!user.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(userMapper.userToUserDto(user.get())).build();
    }
    @GET
    @Path("{driver_id}/ownerships")
    @Secured
    public Response getOwnerships(@PathParam("driver_id") Long driver_id){
        Optional<User> user = userFacade.findById(driver_id);
        if(!user.isPresent()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        List<Ownership> ownerships = ownershipFacade.findByUser(user.get());
        List<OwnershipDto> ownershipDtos = ownershipMapper.ownershipsToOwnershipDtos(ownerships);
        return Response.ok(ownershipDtos).build();
	}
}

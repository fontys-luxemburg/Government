package government.controller;

import government.annotation.Secured;
import government.facade.JwtFacade;
import government.facade.OwnershipFacade;
import government.facade.UserFacade;
import government.mapper.UserMapper;
import government.model.AuthResponse;
import government.model.Ownership;
import government.model.User;
import government.model.Vehicle;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;
import java.util.Optional;

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
    @Context
    SecurityContext context;

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
    @Path("{driver_id}/vehicles")
    @Secured
    public Response getVehicles(@PathParam("driver_id") Long driver_id){
        Optional<User> user = userFacade.findById(driver_id);
        if(!user.isPresent()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        List<Ownership> ownerships = ownershipFacade.findByUser(user.get());
        return Response.ok()
    }
}

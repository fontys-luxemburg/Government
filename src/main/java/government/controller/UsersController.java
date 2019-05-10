package government.controller;

import government.annotation.Secured;
import government.facade.JwtFacade;
import government.facade.UserFacade;
import government.model.AuthResponse;
import government.model.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/users")
@Produces("application/json")
@Consumes("application/json")
public class UsersController {

    @Inject
    UserFacade userFacade;

    @Inject
    JwtFacade jwt;

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
}

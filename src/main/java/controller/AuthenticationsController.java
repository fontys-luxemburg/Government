package controller;

import facade.JwtFacade;
import facade.UserFacade;
import model.AuthResponse;
import model.Credentials;
import model.User;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;ta
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/authentication")
@Produces("application/json")
@Consumes("application/json")
public class AuthenticationsController {

    @Inject
    UserFacade userFacade;

    @Inject
    JwtFacade jwt;

    @POST
    public Response login(Credentials credentials) {
        try {
            User user = authenticate(credentials);
            String token = jwt.issueToken(credentials.getEmail());

            return Response.ok(new AuthResponse(user, token)).build();
        } catch (Exception e) {
            JsonObject errorObject = Json.createObjectBuilder().add("message", e.getLocalizedMessage()).build();
            return Response.status(Response.Status.UNAUTHORIZED).entity(errorObject).build();
        }
    }

    private User authenticate(Credentials credentials) throws Exception {
        Optional<User> user = userFacade.findByEmail(credentials.getEmail());

        if (!user.isPresent()) {
            throw new Exception("User does not exist");
        }

        if (!UserFacade.encodeSHA256(credentials.getPassword()).equals(user.get().getPassword())) {
            throw new Exception("Password not correct");
        }

        return user.get();
    }

}

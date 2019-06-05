package government.controller;

import government.dto.UserDto;
import government.dto.VehicleDto;
import government.facade.UserFacade;
import government.facade.VehicleFacade;
import government.model.SearchResults;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/search")
@Produces("application/json")
public class SearchController {

    @Inject
    VehicleFacade vehicleFacade;

    @Inject
    UserFacade userFacade;

    @GET
    public Response index(@QueryParam("query") String query) {
        if (query == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        List<VehicleDto> vehicles = vehicleFacade.search(query);
        List<UserDto> users = userFacade.search(query);

        return Response.ok(new SearchResults(vehicles, users)).build();
    }
}

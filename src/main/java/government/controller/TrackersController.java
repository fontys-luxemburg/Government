package government.controller;

import government.annotation.Secured;
import government.facade.TrackerIdFacade;
import government.model.Role;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/trackers")
@Produces("application/json")
@Secured({Role.Employee, Role.Admin})
public class TrackersController {

    @Inject
    TrackerIdFacade trackerIdFacade;

    @GET
    @Path("/dates")
    public Response TripsBetweenDates(Date startDate, Date endDate){

        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

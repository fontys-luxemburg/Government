package government.controller;

import government.annotation.Secured;
import government.dto.TrackerIdDto;
import government.facade.TrackerIdFacade;
import government.model.Role;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Path("/trackers")
@Produces("application/json")
@Secured({Role.Employee, Role.Admin})
public class TrackersController {

    @Inject
    TrackerIdFacade trackerIdFacade;

    @GET
    @Path("/dates")
    public Response TripsBetweenDates(){
        //TODO: FIX
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -11);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new Date());
        cal2.add(Calendar.DATE, 10);

        String registrationId = "AB1234";

        List<TrackerIdDto> trackers = trackerIdFacade.getTrackersFromVehicleBetweenDates(registrationId, cal.getTime(), cal2.getTime());

        if (trackers == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(trackers).build();
    }
}

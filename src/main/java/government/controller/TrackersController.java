package government.controller;

import government.annotation.Secured;
import government.dto.TrackerIdDto;
import government.facade.TrackerIdFacade;
import government.model.Role;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    public Response TripsBetweenDates(
            @QueryParam("vehicleID") String vehicleID,
            @QueryParam("begin") Long begin,
            @QueryParam("end") Long end) {
        Date beginDate = new Date(begin);
        Date endDate = new Date(end);
        List<TrackerIdDto> trackers = trackerIdFacade.getTrackersFromVehicleBetweenDates(vehicleID, beginDate, endDate);

        if (trackers == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(trackers).build();
    }
    @GET
    @Path("/driver")
    public Response TripsBetweenDatesForUser(
            @QueryParam("driver_id") String driverId,
            @QueryParam("begin") Long begin,
            @QueryParam("end") Long end) {
        Date beginDate = new Date(begin);
        Date endDate = new Date(end);
        List<TrackerIdDto> trackers = trackerIdFacade.getTrackersFromVehicleBetweenDates(driverId, beginDate, endDate);

        if (trackers == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(trackers).build();
    }
}

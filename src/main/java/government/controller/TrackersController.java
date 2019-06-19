package government.controller;

import government.annotation.Secured;
import government.dto.TrackerIdDto;
import government.dto.TripDto;
import government.facade.OwnershipFacade;
import government.facade.TrackerIdFacade;
import government.facade.UserFacade;
import government.model.Ownership;
import government.model.Role;
import government.model.User;
import sun.swing.BakedArrayList;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/trackers")
@Produces("application/json")
@Secured({Role.Employee, Role.Admin})
public class TrackersController {

    @Inject
    TrackerIdFacade trackerIdFacade;
    @Inject
    OwnershipFacade ownershipFacade;

    @GET
    @Path("/dates")
    public Response TripsBetweenDates (
            @QueryParam("registrationID") String vehicleID,
            @QueryParam("begin") Long begin,
            @QueryParam("end") Long end) throws Exception{
        Date beginDate = new Date(begin);
        Date endDate = new Date(end);
        List<TrackerIdDto> trackers = trackerIdFacade.getTrackersFromVehicleBetweenDates(vehicleID, beginDate, endDate);

        if (trackers == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(trackerIdFacade.getTripsFromTrackers(trackers)).build();
    }

    @GET
    @Path("/driver/{driver_id}")
    public Response TripsBetweenDatesForUser(
            @PathParam("driver_id") String driverId) throws Exception{
        List<Ownership> ownerships = ownershipFacade.findByUserId(Long.valueOf(driverId));
        if (ownerships == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        List<TrackerIdDto> trackers = new ArrayList<>();
        for (Ownership ownership : ownerships) {
            if(ownership.getVehicle()!=null) {
                Date beginDate = ownership.getCreatedAt();
                Date endDate = ownership.getEndDate();
                if(endDate == null){
                    endDate = new Date(beginDate.getTime()+1);
                }
                trackers.addAll(trackerIdFacade.getTrackersFromVehicleBetweenDates(ownership.getVehicle().getRegistrationID(),
                        beginDate, endDate));
            }
        }
        if (trackers.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(trackerIdFacade.getTripsFromTrackers(trackers)).build();
    }
}

package controller;

import facade.TrackerFacade;
import model.TrackerId;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.UUID;

@Path("/trackers")
@Produces("application/json")
public class TrackerController {

    @Inject
    TrackerFacade facade;

    @GET
    @Path("{tracker_id}")
    @Transactional
    public Response show(@PathParam("tracker_id") String trackerId) {
        Optional<TrackerId> tracker = facade.findByTrackerID(UUID.fromString(trackerId));

        if(!tracker.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(tracker.get()).build();
    }
}
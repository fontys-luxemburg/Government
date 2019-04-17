package government.controller;

import government.facade.OwnershipFacade;
import government.facade.VehicleFacade;
import government.model.Vehicle;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/vehicles")
@Produces("application/json")
public class VehiclesController {

    @Inject
    VehicleFacade facade;

    @Inject
    OwnershipFacade ownershipFacade;

    @GET
    @Path("{registration_id}")
    @Transactional
    public Response show(@PathParam("registration_id") String registrationID) {
        Optional<Vehicle> vehicle = facade.findByRegistrationID(registrationID);

        if(!vehicle.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(vehicle.get()).build();
    }

    @GET
    @Path("{registration_id}/ownerships")
    public Response showOwnerships(@PathParam("registration_id") String registrationID) {
        Optional<Vehicle> vehicle = facade.findByRegistrationID(registrationID);

        if(!vehicle.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(ownershipFacade.findAll(vehicle.get())).build();
    }

}

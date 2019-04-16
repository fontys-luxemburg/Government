package government.controller;

import government.annotation.Secured;
import government.facade.VehicleFacade;
import government.model.Role;
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
    @Secured({Role.Employee, Role.Admin})
    @Path("/all")
    @Transactional
    public Response getAll()
    {
        return Response.ok(facade.findAll()).build();
    }
}

package government.controller;

import government.dto.VehicleDto;
import government.facade.VehicleFacade;
import government.model.Vehicle;
import government.mapper.VehicleMapper;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/vehicles")
@Produces("application/json")
public class VehiclesController {

    @Inject
    VehicleFacade facade;

    @Inject
    VehicleMapper vehicleMapper;

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

    @POST
    @Transactional
    public Response save(VehicleDto vehicleDto) {

        Vehicle vehicle  = vehicleMapper.vehicleDtoToVehicle(vehicleDto);

        vehicle = facade.save(vehicle);

        if (vehicle.getId() == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.CREATED).build();
    }
}

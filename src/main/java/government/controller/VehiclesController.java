package government.controller;

import government.annotation.Secured;
import government.dto.TrackerIdDto;
import government.dto.UserDto;
import government.dto.VehicleDto;
import government.dto.VehicleInformationDto;
import government.mapper.VehicleInformationMapper;
import government.model.TrackerId;
import government.facade.OwnershipFacade;
import government.facade.UserFacade;
import government.facade.VehicleFacade;
import government.mapper.TrackerIdMapper;
import government.mapper.VehicleMapper;
import government.model.Role;
import government.model.User;
import government.model.Vehicle;
import government.model.VehicleInformation;
import jdk.nashorn.internal.objects.annotations.Getter;
import javax.swing.text.html.Option;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/vehicles")
@Produces("application/json")
@Secured({Role.Employee, Role.Admin})
public class VehiclesController {

    @Inject
    VehicleFacade facade;

    @Inject
    OwnershipFacade ownershipFacade;

    @Inject
    UserFacade userFacade;

    @Inject
    VehicleMapper vehicleMapper;

    @Inject
    TrackerIdMapper trackerIdMapper;
    
    @Inject
    VehicleInformationMapper vehicleInformationMapper;

    @GET
    @Path("{registration_id}")
    @Transactional
    public Response show(@PathParam("registration_id") String registrationID) {
        Optional<Vehicle> vehicle = facade.findByRegistrationID(registrationID);

        if (!vehicle.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(vehicleMapper.vehicleToVehicleDto(vehicle.get())).build();
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

    @POST
    @Path("{registration_id}/ownerships")
    @Transactional
    public Response transfersOwnership(@PathParam("registration_id") String registrationID, JsonObject params) {
        Optional<Vehicle> vehicle = facade.findByRegistrationID(registrationID);

        if(!vehicle.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Optional<User> receivingUser = userFacade.findById((long) params.getInt("user_id"));
        receivingUser.ifPresent(user -> ownershipFacade.transferVehicleToUser(vehicle.get(), user));

        return Response.ok().build();
    }

    @POST
    @Transactional
    public Response save(VehicleDto vehicleDto) {

        Vehicle vehicle = vehicleMapper.vehicleDtoToVehicle(vehicleDto);

        vehicle = facade.save(vehicle);

        if (vehicle.getId() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        vehicleDto = vehicleMapper.vehicleToVehicleDto(vehicle);
        return Response.status(Response.Status.CREATED).entity(vehicleDto).build();
    }

    @POST
    @Path("/{id}/trackers")
    @Transactional
    public Response createTracker(){
        return Response.ok().build();
    }

    @GET
    @Path("/{id}/trackers")
    @Transactional
    public Response getAllTrackers(@PathParam("id") long id) {
        Optional<Vehicle> vehicle = facade.findById(id);
        if (!vehicle.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        List<TrackerIdDto> trackers = trackerIdMapper.trackerIdsToTrackerIdDtos(vehicle.get().getTrackers());
        return Response.ok(trackers).build();
    }

    @GET
    @Path("/all")
    @Transactional
    public Response getAll() {
        return Response.ok(facade.findAll()).build();
    }

    @GET
    @Path("/{id}/information")
    @Transactional
    public Response getVehicleInformation(@PathParam("id") String id) {
        Optional<Vehicle> vehicle = facade.findByRegistrationID(id);
        if (!vehicle.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        VehicleInformationDto vehicleInformationDto = vehicleInformationMapper.vehicleInformationToDto(vehicle.get().getVehicleInformation());
        return Response.ok(vehicleInformationDto).build();
    }

    @PUT
    @Path("/{id}/information")
    @Transactional
    public Response updateVehicleInformation(@PathParam("id") long id, VehicleInformationDto vehicleInformationDto) {
        Optional<Vehicle> vehicle = facade.findById(id);
        if (!vehicle.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        VehicleInformation vehicleInformation = vehicleInformationMapper.vehicleInformationDtoToVehicleInformation(vehicleInformationDto);
        vehicle.get().setVehicleInformation(vehicleInformation);
        facade.save(vehicle.get());
        return Response.ok().build();
    }
}

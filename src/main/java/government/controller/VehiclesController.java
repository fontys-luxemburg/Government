package government.controller;


import government.dto.TrackerIdDto;
import government.dto.VehicleDto;
import government.dto.VehicleInformationDto;
import government.facade.VehicleFacade;
import government.mapper.TrackerIdMapper;
import government.mapper.VehicleInformationMapper;
import government.model.TrackerId;
import government.annotation.Secured;
import government.model.Role;
import government.model.Vehicle;
import government.mapper.VehicleMapper;
import government.model.VehicleInformation;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/vehicles")
@Produces("application/json")
public class VehiclesController {

    @Inject
    VehicleFacade facade;

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

    @POST
    @Path("/{id}/trackers")
    @Transactional
    public Response createTracker(){



        return Response.ok().build();
    }

    @GET
    @Path("/{id}/trackers")
    @Transactional
    public Response getAllTrackers(@PathParam("id") long id){
        Optional<Vehicle> vehicle = facade.findById(id);
        if(!vehicle.isPresent()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        List<TrackerIdDto> trackers = trackerIdMapper.trackerIdsToTrackerIdDtos(vehicle.get().getTrackers());
        return Response.ok(trackers).build();
    }
    @GET
    @Secured({Role.Employee, Role.Admin})
    @Path("/all")
    @Transactional
    public Response getAll()
    {
        return Response.ok(facade.findAll()).build();
    }

    @GET
    @Path("/{id}/information")
    @Transactional
    public Response getVehicleInformation(@PathParam("id") long id){
        Optional<Vehicle> vehicle = facade.findById(id);
        if(!vehicle.isPresent()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        VehicleInformationDto vehicleInformationDto =vehicleInformationMapper. vehicle.get().getVehicleInformation();
    }
}

package government.controller;

import government.annotation.Secured;
import government.dto.TrackerIdDto;
import government.dto.VehicleDto;
import government.facade.TrackerIdFacade;
import government.dto.VehicleInformationDto;
import government.mapper.VehicleInformationMapper;
import government.model.*;
import government.facade.OwnershipFacade;
import government.facade.UserFacade;
import government.facade.VehicleFacade;
import government.mapper.TrackerIdMapper;
import government.mapper.VehicleMapper;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Path("/vehicles")
@Produces("application/json")
@Secured({Role.Employee, Role.Admin})
public class VehiclesController {

    @Inject
    VehicleFacade vehicleFacade;

    @Inject
    TrackerIdFacade trackerIdFacade;

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

    Random rand = new Random();

    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @GET
    @Path("{registration_id}")
    @Transactional
    public Response show(@PathParam("registration_id") String registrationID) {
        Optional<Vehicle> vehicle = vehicleFacade.findByRegistrationID(registrationID);

        if (!vehicle.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(vehicleMapper.vehicleToVehicleDto(vehicle.get())).build();
    }

    @GET
    @Path("registrationID")
    public String getRegistrationID() {
        String registration;

        while (true) {
            registration = generateRegistrationID();
            Optional<Vehicle> vehicle = vehicleFacade.findByRegistrationID(registration);
            if(!vehicle.isPresent()) { break; }
        }

        return registration;
    }

    private String generateRegistrationID() {
        String randomString = String.format("%c%c", randomCharacter(), randomCharacter());
        int numbers = rand.nextInt(9999);
        String paddedNumbers = String.format("%04d", numbers);

        return randomString + paddedNumbers;
    }

    private Character randomCharacter() {
        return alphabet.charAt(rand.nextInt(25));
    }

    @GET
    @Path("{registration_id}/ownerships")
    public Response showOwnerships(@PathParam("registration_id") String registrationID) {
        Optional<Vehicle> vehicle = vehicleFacade.findByRegistrationID(registrationID);

        if(!vehicle.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(ownershipFacade.findAll(vehicle.get())).build();
    }

    @POST
    @Path("{registration_id}/ownerships")
    @Transactional
    public Response transfersOwnership(@PathParam("registration_id") String registrationID, JsonObject params) {
        Optional<Vehicle> vehicle = vehicleFacade.findByRegistrationID(registrationID);

        if(!vehicle.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Optional<User> receivingUser = userFacade.findById((long) params.getInt("user_id"));
        receivingUser.ifPresent(user -> ownershipFacade.transferVehicleToUser(vehicle.get(), user));

        return Response.ok().build();
    }

    @POST
    @Transactional
    @Consumes("application/json")
    public Response save(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleMapper.vehicleDtoToVehicle(vehicleDto);

        vehicle = vehicleFacade.save(vehicle);

        if (vehicle.getId() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        vehicleDto = vehicleMapper.vehicleToVehicleDto(vehicle);
        return Response.status(Response.Status.CREATED).entity(vehicleDto).build();
    }

    @POST
    @Path("/{id}/trackers")
    @Transactional
    public Response createTracker(@PathParam("id") String vehicleId) {
        Optional<TrackerId> optionalTrackerId = trackerIdFacade.findLastTrackerByVehicle(vehicleId);

        if (optionalTrackerId.isPresent()) {
            TrackerId trackerId = optionalTrackerId.get();
            trackerId.setDestroyedDate(getCurrentDate());
            trackerIdFacade.save(trackerId);
        }

        UUID uuid = getTracker();
        if (uuid == null) {
            return Response.noContent().build();
        }

        TrackerId trackerId = new TrackerId();
        trackerId.setTrackerId(uuid);
        Vehicle vehicle = vehicleFacade.findByRegistrationID(vehicleId).get();
        trackerId.setVehicle(vehicle);

        trackerIdFacade.save(trackerId);

        return Response.ok().build();
    }

    @GET
    @Path("/{registrationId}/trackers")
    @Transactional
    public Response getAllTrackers(@PathParam("registrationId") String registrationId) {
        Optional<Vehicle> vehicle = vehicleFacade.findByRegistrationID(registrationId);
        if (!vehicle.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        List<TrackerIdDto> trackers = trackerIdMapper.trackerIdsToTrackerIdDtos(vehicle.get().getTrackers());
        return Response.ok(trackers).build();
    }

    @GET
    @Path("/{registration_id}/information")
    @Transactional
    public Response getVehicleInformation(@PathParam("registration_id") String registrationID) {
        Optional<Vehicle> vehicle = vehicleFacade.findByRegistrationID(registrationID);
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
        Optional<Vehicle> vehicle = vehicleFacade.findById(id);
        if (!vehicle.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        VehicleInformation vehicleInformation = vehicleInformationMapper.vehicleInformationDtoToVehicleInformation(vehicleInformationDto);
        vehicle.get().setVehicleInformation(vehicleInformation);
        vehicleFacade.save(vehicle.get());
        return Response.ok().build();
    }

    private Date getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);
        return date;
    }

    private UUID getTracker(){
        try{
            URL url = new URL("http://localhost:8080/tracking.war/api/trackers");
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            http.setRequestMethod("POST");
            http.setDoOutput(true);

            http.connect();
            try(InputStream os = http.getInputStream()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(os));
                String line = reader.readLine().replaceAll("^\"|\"$", "");
                return UUID.fromString(line);
            }
        } catch(IOException e){
            return null;
        }
    }
}

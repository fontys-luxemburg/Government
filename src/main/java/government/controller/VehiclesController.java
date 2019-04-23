package government.controller;

import com.sun.deploy.net.HttpResponse;
import government.dto.VehicleDto;
import government.facade.TrackerIdFacade;
import government.facade.VehicleFacade;
import government.model.TrackerId;
import government.model.Vehicle;
import government.mapper.VehicleMapper;

import javax.inject.Inject;
import javax.net.ssl.HttpsURLConnection;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("/vehicles")
@Produces("application/json")
public class VehiclesController {

    @Inject
    VehicleFacade facade;

    @Inject
    TrackerIdFacade trackerIdFacade;

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

    @POST
    @Path("/{id}/trackers")
    @Transactional
    public Response createTracker(@PathParam("id") Long vehicleId){

        List<TrackerId> trackerIds = trackerIdFacade.findByVehicleId(vehicleId);

        if (!trackerIds.isEmpty()){
            trackerIds.get(trackerIds.size() - 1).setDestroyedDate(getCurrentDate());
        }

        UUID uuid = getTracker();
        if (uuid == null){
            return Response.noContent().build();
        }

        TrackerId trackerId = new TrackerId();
        trackerId.setTrackerId(uuid);
        trackerId.setVehicle(facade.findById(vehicleId).get());

        trackerIdFacade.save(trackerId);

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
                String line = reader.readLine();
                return UUID.fromString(line);
            }
        } catch(IOException e){
            return null;
        }
    }
}

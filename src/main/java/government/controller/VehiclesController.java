package government.controller;

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
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

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
    public Response createTracker(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        dateFormat.format(date);

        TrackerId trackerId = trackerIdFacade.findAll().get(0);

        if (trackerId != null){
            trackerId.setDestroyedDate(date);
        }

        return Response.ok().build();
    }

    private void sendPost(){
        String url = "http://localhost:8080/tracking.war/api/trackers";

        try {
            URL obj = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

            //add request header
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.flush();
            wr.close();

            //int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

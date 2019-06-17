package government.facade;

import government.Urls;
import government.dto.TrackerIdDto;
import government.dto.TripDto;
import government.model.TrackerId;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

@ApplicationScoped
public class TrackerIdFacade implements BaseFacade<TrackerId, Long> {

    private Urls urls = new Urls();
    @Override
    public Optional<TrackerId> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<TrackerId> findAll() {
        return null;
    }

    @Override
    public TrackerId save(TrackerId entity) {
        return null;
    }

    public List<TrackerIdDto> getTrackersFromVehicle(String registrationId){
        try{
            Client client = ClientBuilder.newBuilder().build();
            WebTarget target = client.target(urls.getTrackerUrl()+"/api/trackers/vehicle/" + registrationId);
            Response response = target.request().get();
            TrackerIdDto[] trackers = response.readEntity(TrackerIdDto[].class);
            return Arrays.asList(trackers);
        } catch(Exception e){
            return null;
        }
    }

    public List<TrackerIdDto> getTrackersFromVehicleBetweenDates(String registrationId, Date beginDate, Date endDate){
        try{
            Client client = ClientBuilder.newBuilder().build();
            WebTarget target;
            if(endDate != null) {
                 target = client.target(urls.getTrackerUrl() + "/api/trackers/vehicle")
                        .queryParam("vehicleID", registrationId)
                        .queryParam("begin", beginDate.getTime())
                        .queryParam("end", endDate.getTime());
            }else{
                target = client.target(urls.getTrackerUrl() + "/api/trackers/vehicle")
                        .queryParam("vehicleID", registrationId)
                        .queryParam("begin", beginDate.getTime())
                        .queryParam("end", "");
            }
            Response response = target.request().get();
            TrackerIdDto[] trackers = response.readEntity(TrackerIdDto[].class);
            return Arrays.asList(trackers);
        } catch(Exception e){
            return null;
        }
    }

    public UUID newTracker(String vehicleID){
        try{
            URL url = new URL(urls.getTrackerUrl()+"/api/trackers/" + vehicleID);
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
    public List<TripDto> getTripsFromTrackers(List<TrackerIdDto> trackers){

        List<TripDto> trips = new ArrayList();

        for (TrackerIdDto tracker : trackers) {
            for(TripDto trip: tracker.getTrips()){
                trip.setRegistrationID(tracker.getVehicleID());
                trips.add(trip);
            }
        }
        return trips;

    }
}

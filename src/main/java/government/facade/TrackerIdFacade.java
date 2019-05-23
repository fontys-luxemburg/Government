package government.facade;

import government.dto.TrackerIdDto;
import government.model.TrackerId;
import government.repository.TrackerIdRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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

    @Inject
    TrackerIdRepository repository;

    @Override
    public Optional<TrackerId> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<TrackerId> findAll() {
        return repository.findAll();
    }

    public Optional<TrackerId> findLastTrackerByVehicle(String trackerId){
        return repository.findLastTrackerByVehicle(trackerId);
    }

    @Override
    public TrackerId save(TrackerId entity) {
        repository.save(entity);
        return entity;
    }

    public List<TrackerIdDto> getTrackersFromVehicle(String registrationId){
        try{
            Client client = ClientBuilder.newBuilder().build();
            WebTarget target = client.target("http://localhost:8080/tracking.war/api/trackers/vehicle/" + registrationId);
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
            WebTarget target = client.target("http://localhost:8080/tracking.war/api/trackers/vehicle")
                    .queryParam("vehicleID", registrationId)
                    .queryParam("begin", beginDate.getTime())
                    .queryParam("end", endDate.getTime());

            Response response = target.request().get();
            TrackerIdDto[] trackers = response.readEntity(TrackerIdDto[].class);
            return Arrays.asList(trackers);
        } catch(Exception e){
            return null;
        }
    }

    public UUID newTracker(){
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

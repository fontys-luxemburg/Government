package government.facade;

import government.Urls;
import government.dto.TrackerIdDto;
import government.dto.TripDto;
import government.model.TrackerId;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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

    public List<TrackerIdDto> getTrackersFromVehicle(String registrationId) {
        try {
            Client client = ClientBuilder.newBuilder().build();
            WebTarget target = client.target(urls.getTrackerUrl() + "/api/trackers/vehicle/" + registrationId);
            Response response = target.request().get();
            TrackerIdDto[] trackers = response.readEntity(TrackerIdDto[].class);
            return Arrays.asList(trackers);
        } catch (Exception e) {
            return null;
        }
    }

    public List<TrackerIdDto> getTrackersFromVehicleBetweenDates(String registrationId, Date beginDate, Date endDate) throws Exception {
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target;
        target = client.target(urls.getTrackerUrl() + "/api/trackers/vehicle")
                .queryParam("vehicleID", registrationId)
                .queryParam("begin", beginDate.getTime())
                .queryParam("end", endDate.getTime());
        Response response = target.request(MediaType.APPLICATION_JSON).get(Response.class);
        if (response.hasEntity() && response.getStatus() == 200) {
            try {
                TrackerIdDto[] trackers = response.readEntity(TrackerIdDto[].class);
                return Arrays.asList(trackers);
//                try {
//
//                    JsonObject list = response.readEntity(JsonObject.class);
            } catch (Exception e) {
                throw new Exception(e.getMessage() + "  response" + response);
            }
        } else {
            throw new Exception("  response" + response);
        }
    }

    public UUID newTracker(String vehicleID) {
        try {
            URL url = new URL(urls.getTrackerUrl() + "/api/trackers/" + vehicleID);
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) con;
            http.setRequestMethod("POST");
            http.setDoOutput(true);

            http.connect();
            try (InputStream os = http.getInputStream()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(os));
                String line = reader.readLine().replaceAll("^\"|\"$", "");
                return UUID.fromString(line);
            }
        } catch (IOException e) {
            return null;
        }
    }

    public List<TripDto> getTripsFromTrackers(List<TrackerIdDto> trackers) {

        List<TripDto> trips = new ArrayList();
        for (TrackerIdDto tracker : trackers) {
            for (TripDto trip : tracker.getTrips()) {
                trip.setRegistrationID(tracker.getVehicleID());
                trips.add(trip);
            }
        }
        return trips;

    }

    public List<TripDto> getTripsFromTrackersUser(List<TrackerIdDto> trackerIds) throws Exception {
        List<TripDto> tripDtos = new ArrayList<>();
        for (TrackerIdDto trackerId : trackerIds) {
            Client client = ClientBuilder.newBuilder().build();
            WebTarget target;
            target = client.target(urls.getTrackerUrl() + "/api/trips/tracker/" + trackerId.getTrackerId());
            Response response = target.request(MediaType.APPLICATION_JSON).get(Response.class);
            if (response.hasEntity() && response.getStatus() == 200) {
                try {
                    TripDto[] trackers = response.readEntity(TripDto[].class);
                    for(TripDto tripDto:  Arrays.asList(trackers) ){
                        tripDto.setRegistrationID(trackerId.getVehicleID());
                        tripDtos.add(tripDto);
                    }
                    return tripDtos;
                } catch (Exception e) {
                    throw new Exception(e.getMessage() + "  response" + response);
                }
            } else {
                throw new Exception("  response" + response);
            }
        }

        return tripDtos;
    }
    public List<TripDto> getTripsFromTrackersFromDate(List<TrackerIdDto> trackerIdDtos,Long startDate,Long endDate)throws Exception {
       List<TripDto> updateList = new ArrayList<>();
        for (TrackerIdDto trackerId : trackerIdDtos) {
            Client client = ClientBuilder.newBuilder().build();
            WebTarget target;
            target = client.target(urls.getTrackerUrl() + "/api/trips/tracker/" + trackerId.getTrackerId() + "/date" + "?startDate=" +
                    startDate + "?endDate=" + endDate);
            Response response = target.request(MediaType.APPLICATION_JSON).get(Response.class);

            try {
                List<TripDto> tripDtos = Arrays.asList(response.readEntity(TripDto[].class));
                for (TripDto tripDto : tripDtos) {
                    tripDto.setRegistrationID(trackerId.getVehicleID());
                    tripDtos.add(tripDto);
                }
                updateList.addAll(tripDtos);
            } catch (Exception e) {
                throw new Exception(e.getMessage() + "  response" + response);
            }
        }
        return updateList;
    }
}

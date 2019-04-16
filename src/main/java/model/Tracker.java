package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Tracker extends BaseEntity {

    private UUID trackerId;
    private String name;
    private List<Trip> trips = new ArrayList<>();

    public Tracker() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(UUID trackerId) {
        this.trackerId = trackerId;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}

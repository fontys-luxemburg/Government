package government.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TrackerIdDto extends BaseDto {

    private UUID trackerId;

    private String vehicleID;

    private Date destroyedDate;

    private List<TripDto> trips;

    public UUID getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(UUID trackerId) {
        this.trackerId = trackerId;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public Date getDestroyedDate() {
        return destroyedDate;
    }

    public void setDestroyedDate(Date destroyedDate) {
        this.destroyedDate = destroyedDate;
    }

    public List<TripDto> getTrips() {
        return trips;
    }

    public void setTrips(List<TripDto> trips) {
        this.trips = trips;
    }
}

package government.dto;

import java.util.Date;
import java.util.UUID;

public class TrackerIdDto extends BaseDto {

    private UUID trackerId;

    private Long vehicleId;

    private Date destroyedDate;

    public UUID getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(UUID trackerId) {
        this.trackerId = trackerId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Date getDestroyedDate() {
        return destroyedDate;
    }

    public void setDestroyedDate(Date destroyedDate) {
        this.destroyedDate = destroyedDate;
    }
}

package government.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle extends BaseEntity {

    @NotNull
    @NotBlank
    private String registrationID;
    private String brand;

    private String model;
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<TrackerId> trackers = new ArrayList<>();

    @OneToOne(mappedBy = "vehicle",fetch = FetchType.LAZY)
    private VehicleInformation vehicleInformation;

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public List<TrackerId> getTrackers() {
        return trackers;
    }

    public void setTrackers(List<TrackerId> trackers) {
        this.trackers = trackers;
    }

    public VehicleInformation getVehicleInformation() {
        return vehicleInformation;
    }

    public void setVehicleInformation(VehicleInformation vehicleInformation) {
        this.vehicleInformation = vehicleInformation;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

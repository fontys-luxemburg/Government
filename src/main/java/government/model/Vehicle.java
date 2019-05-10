package government.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle extends BaseEntity {

    @NotNull
    @NotBlank
    private String registrationID;
    private String brand;
    private String bodyType ;
    private String model;

    @OneToMany(mappedBy = "vehicle")
    private List<Ownership> ownerships;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<TrackerId> trackers = new ArrayList<>();
    @OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private VehicleInformation vehicleInformation = new VehicleInformation(this);

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

    public VehicleInformation getVehicleInformation() {
        return vehicleInformation;
    }

    public void setVehicleInformation(VehicleInformation vehicleInformation) {
        this.vehicleInformation = vehicleInformation;
    }

    public List<Ownership> getOwnerships() {
        return ownerships;
    }

    public void setOwnerships(List<Ownership> ownerships) {
        this.ownerships = ownerships;
    }

    public void addOwnership(Ownership ownership) {
        ownership.setVehicle(this);
        this.ownerships.add(ownership);
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
    
    public String getBodyType() {
        return bodyType;
    }
}

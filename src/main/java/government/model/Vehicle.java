package government.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    private String bodyType;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<TrackerId> trackers = new ArrayList<>();

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
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

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public List<TrackerId> getTrackers() {
        return trackers;
    }

    public void setTrackers(List<TrackerId> trackers) {
        this.trackers = trackers;
    }
}

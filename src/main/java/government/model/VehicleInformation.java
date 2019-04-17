package government.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "vehicleInformation")
public class VehicleInformation extends BaseEntity {

    private String bodyType;
    private String type;
    private String color;
    private String tradeName;
    private Date registrationDate;
    private Date apkExperationDate;
    private boolean stolen;
    private boolean exported;
    private boolean wamInsured;
    private boolean mayRideOnRoad;
    private int catalogPrice;
    @OneToOne(mappedBy = "vehicleInformation",fetch = FetchType.LAZY)
    private Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getApkExperationDate() {
        return apkExperationDate;
    }

    public void setApkExperationDate(Date apkExperationDate) {
        this.apkExperationDate = apkExperationDate;
    }

    public boolean isStolen() {
        return stolen;
    }

    public void setStolen(boolean stolen) {
        this.stolen = stolen;
    }

    public boolean isExported() {
        return exported;
    }

    public void setExported(boolean exported) {
        this.exported = exported;
    }

    public boolean isWamInsured() {
        return wamInsured;
    }

    public void setWamInsured(boolean wamInsured) {
        this.wamInsured = wamInsured;
    }

    public boolean isMayRideOnRoad() {
        return mayRideOnRoad;
    }

    public void setMayRideOnRoad(boolean mayRideOnRoad) {
        this.mayRideOnRoad = mayRideOnRoad;
    }

    public int getCatalogPrice() {
        return catalogPrice;
    }

    public void setCatalogPrice(int catalogPrice) {
        this.catalogPrice = catalogPrice;
    }
}

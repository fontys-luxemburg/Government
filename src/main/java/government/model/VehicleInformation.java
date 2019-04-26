package government.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "vehicleInformation")
public class VehicleInformation extends BaseEntity {

    private String type ;
    private String color;
    private String tradeName ;
    private Date registrationDate;
    private Date apkExperationDate;
    private boolean stolen;
    private boolean exported;
    private boolean wamInsured;
    private boolean mayRideOnRoad;
    private int catalogPrice;
    @OneToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;

    public VehicleInformation(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.type = "not specified";
        this.color = "not specified";
        this.tradeName = "not specified";
        this.catalogPrice = 0;
    }

    public VehicleInformation() {
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}

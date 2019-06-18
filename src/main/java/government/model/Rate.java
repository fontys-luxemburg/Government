package government.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rates")
public class Rate extends BaseEntity {
    private double carRate;
    private double truckRate;
    private double busRate;

    @OneToMany(mappedBy = "rate")
    private List<RushRate> rushRates = new ArrayList<>();

    public Rate() {
    }

    public Rate(double carRate, double truckRate, double busRate) {
        this.carRate = carRate;
        this.truckRate = truckRate;
        this.busRate = busRate;
    }

    public double getCarRate() {
        return carRate;
    }

    public void setCarRate(double carRate) {
        this.carRate = carRate;
    }

    public double getTruckRate() {
        return truckRate;
    }

    public void setTruckRate(double truckRate) {
        this.truckRate = truckRate;
    }

    public double getBusRate() {
        return busRate;
    }

    public void setBusRate(double busRate) {
        this.busRate = busRate;
    }

    public List<RushRate> getRushRates() {
        return rushRates;
    }

    public void addRushRate(RushRate rushRate) {
        rushRate.setRate(this);
        rushRates.add(rushRate);
    }

    public double rateForVehicle(Vehicle vehicle) {
        switch (vehicle.getBodyType()) {
            case "truck":
                return getTruckRate();
            case "bus":
                return getBusRate();
            default:
                return getCarRate();
        }
    }
}

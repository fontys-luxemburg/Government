package government.dto;

import java.util.List;

public class RateDto extends BaseDto {

    private double carRate;
    private double truckRate;
    private double busRate;

    private List<RushRateDto> rushRates;

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

    public List<RushRateDto> getRushRates() {
        return rushRates;
    }

    public void setRushRates(List<RushRateDto> rushRates) {
        this.rushRates = rushRates;
    }
}

package government.dto;

import java.util.Date;

public class TripDto extends BaseDto {

    private Long trackerId;

    private Date startDate;

    private Date endDate;

    private double distanceTraveledKm;

    private String registrationID;

    private double totalPrice;

    public Long getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(Long trackerId) {
        this.trackerId = trackerId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getDistanceTraveledKm() {
        return distanceTraveledKm;
    }

    public void setDistanceTraveledKm(double distanceTraveledKm) {
        this.distanceTraveledKm = distanceTraveledKm;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

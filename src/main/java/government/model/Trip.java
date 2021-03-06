package government.model;

import government.model.TrackerId;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "trips")
public class Trip extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "tracker_id", nullable = false)
    private TrackerId tracker;

    private Date startDate;

    private Date endDate;

    private double distanceTraveledKm;

    private double totalPrice;

    public TrackerId getTracker() {
        return tracker;
    }

    public void setTracker(TrackerId tracker) {
        this.tracker = tracker;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

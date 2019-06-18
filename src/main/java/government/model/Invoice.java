package government.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Vehicle vehicle;
    private Date startDate;
    private Date endDate;
    private boolean paid;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Trip> trips = new ArrayList<>();

    public Invoice() {
    }

    public Invoice(Vehicle vehicle, Date startDate, Date endDate, boolean paid,List<Trip> trips) {
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paid = paid;
        this.trips = trips;
    }
    public Invoice(User user, Date startDate, Date endDate, boolean paid,List<Trip> trips) {
        this.user = user;
        this.paid = paid;
        this.trips = trips;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

}

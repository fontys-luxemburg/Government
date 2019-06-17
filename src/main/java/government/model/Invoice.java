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
    private Date from;
    private Date till;
    private boolean paid;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Trip> trips = new ArrayList<>();

    public Invoice() {
    }

    public Invoice(Vehicle vehicle, Date from, Date till, boolean paid,List<Trip> trips) {
        this.vehicle = vehicle;
        this.from = from;
        this.till = till;
        this.paid = paid;
        this.trips = trips;
    }
    public Invoice(User user, Date from, Date till, boolean paid,List<Trip> trips) {
        this.user = user;
        this.from = from;
        this.till = till;
        this.paid = paid;
        this.trips = trips;
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

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTill() {
        return till;
    }

    public void setTill(Date till) {
        this.till = till;
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

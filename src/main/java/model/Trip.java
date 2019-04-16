package model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trips")
public class Trip extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "tracker_id", nullable = false)
    private TrackerId tracker;

    public TrackerId getTracker() {
        return tracker;
    }

    public void setTracker(TrackerId tracker) {
        this.tracker = tracker;
    }
}

package government.model;

import government.model.Rate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rush_rates")
public class RushRate extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rate_id")
    private Rate rate;

    @NotNull
    private int dayOfWeek;

    @NotNull
    private String startTime;

    @NotNull
    private String endTime;

    @NotNull
    private double multiplier;

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }
}

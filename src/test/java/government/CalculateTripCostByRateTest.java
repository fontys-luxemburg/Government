package government;

import government.model.TrackerId;
import government.model.Trip;
import government.model.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateTripCostByRateTest {

    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    private Trip trip;

    @BeforeEach
    void setUp() throws ParseException {
        trip = new Trip();
        trip.setDistanceTraveledKm(10.0);

        trip.setStartDate(formatter.parse("13-06-2019"));
        trip.setEndDate(formatter.parse("13-06-2019"));

        Vehicle vehicle = new Vehicle();
        vehicle.setBodyType("car");

        TrackerId trackerId = new TrackerId();
        trackerId.setVehicle(vehicle);

        trip.setTracker(trackerId);
    }

    @Test
    void calculate_by_default_rate_test() {
        RateCalculator calculator = new RateCalculator();

        assertEquals(10.0, calculator.costForTrip(trip));
    }

    @Test
    void calculate_by_former_default_rate_test() throws ParseException {
        trip.setStartDate(formatter.parse("03-06-2019"));
        trip.setEndDate(formatter.parse("03-06-2019"));

        RateCalculator calculator = new RateCalculator();
        assertEquals(5.0, calculator.costForTrip(trip));
    }

    @Test
    void different_rate_per_vehicle_test() {
        Vehicle vehicle = new Vehicle();
        vehicle.setBodyType("truck");

        TrackerId trackerId = new TrackerId();
        trackerId.setVehicle(vehicle);

        trip.setTracker(trackerId);

        RateCalculator calculator = new RateCalculator();
        assertEquals(20.0, calculator.costForTrip(trip));
    }

    @Test
    void different_rate_during_rush_hour_test() throws ParseException {
        trip.setStartDate(formatter.parse("26-04-2019"));
        trip.setEndDate(formatter.parse("26-04-2019"));
    }
}

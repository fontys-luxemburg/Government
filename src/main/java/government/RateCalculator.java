package government;

import government.model.Rate;
import government.model.Trip;
import government.repository.RateRepository;

public class RateCalculator {

    private final RateRepository rateRepository = new RateRepository();

    /**
     * Multiply the travelled distance by the rate corresponding to that trip
     * @param trip Trip
     * @return cost of trip in Euros
     */
    public double costForTrip(Trip trip) {
        return trip.getDistanceTraveledKm() * getTripRate(trip);
    }

    private double getTripRate(Trip trip) {
        Rate rate = rateRepository.getRateForDate(trip.getEndDate());

        return rate.rateForVehicle(trip.getTracker().getVehicle());
    }
}

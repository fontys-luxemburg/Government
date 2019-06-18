package government;

import government.facade.TrackerIdFacade;
import government.facade.UserFacade;
import government.facade.VehicleFacade;
import government.model.*;
import government.repository.OwnershipRepository;
import government.repository.RateRepository;
import government.repository.VehicleRepository;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Startup
@Singleton
public class Seeds {

    @Inject
    VehicleRepository vehicleRepository;

    @Inject
    UserFacade userFacade;

    @Inject
    OwnershipRepository ownershipRepository;

    @Inject
    RateRepository rateRepository;

    @PostConstruct
    private void init() {
        System.out.println("STARTED SEEDS");

        // Create users
        User john = new User();
        john.setName("John Doe");
        john.setEmail("johndoe@test.com");
        john.setPassword("testpassword");

        User tim = new User();
        tim.setName("Timothy Tester");
        tim.setEmail("timtest@test.com");
        tim.setPassword("testpassword");

        userFacade.save(john);
        userFacade.save(tim);


        // Create vehicles
        Vehicle peugeot = new Vehicle();
        peugeot.setBrand("Peugeot");
        peugeot.setModel("208");
        peugeot.setRegistrationID("AB1234");
        peugeot.setBodyType("CAR");

        VehicleInformation peugeotInfo = new VehicleInformation();
        peugeotInfo.setColor("GREY");
        peugeotInfo.setCatalogPrice(300000);
        peugeotInfo.setVehicle(peugeot);
        peugeot.setVehicleInformation(peugeotInfo);

        Vehicle bmw = new Vehicle();
        bmw.setBrand("BMW");
        bmw.setModel("i3");
        bmw.setRegistrationID("XY4567");
        bmw.setBodyType("CAR");

        vehicleRepository.save(bmw);
        vehicleRepository.save(peugeot);

        // Create ownerships
        Ownership ownership = new Ownership();
        ownership.setUser(john);
        ownership.setVehicle(peugeot);

        Ownership ownership1 = new Ownership();
        ownership1.setUser(tim);
        ownership1.setVehicle(bmw);

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -10);

        Ownership pastOwnership = new Ownership();
        pastOwnership.setUser(tim);
        pastOwnership.setVehicle(peugeot);
        pastOwnership.setEndDate(cal.getTime());

        ownershipRepository.save(ownership);
        ownershipRepository.save(ownership1);
        ownershipRepository.save(pastOwnership);

        Rate rate = new Rate();
        rate.setCarRate(1.0);
        rate.setBusRate(1.0);
        rate.setTruckRate(1.0);

        RushRate rushRate = new RushRate();
        rushRate.setDayOfWeek(1);
        rushRate.setStartTime("09:00");
        rushRate.setEndTime("12:00");
        rushRate.setMultiplier(1.1);

        Rate rate2 = new Rate();
        rate.setCarRate(2.0);
        rate.setBusRate(2.0);
        rate.setTruckRate(2.0);

        rateRepository.save(rate);
        rateRepository.save(rate2);
    }
}

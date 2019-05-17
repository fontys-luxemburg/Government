package government;

import government.facade.TrackerIdFacade;
import government.facade.UserFacade;
import government.facade.VehicleFacade;
import government.model.Ownership;
import government.model.TrackerId;
import government.model.User;
import government.model.Vehicle;
import government.model.VehicleInformation;
import government.repository.OwnershipRepository;
import government.repository.VehicleRepository;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Startup
@Singleton
public class Seeds {

    @Inject
    VehicleRepository vehicleRepository;

    @Inject
    UserFacade userFacade;

    @Inject
    TrackerIdFacade trackerIdFacade;

    @Inject
    OwnershipRepository ownershipRepository;

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

        // Create trackers
        TrackerId tracker1 = new TrackerId();
        tracker1.setVehicle(peugeot);
        tracker1.setTrackerId(UUID.fromString("38c5be3f-5ec9-4f3a-b597-5b57f42b0f87"));
        tracker1.setDestroyedDate(cal.getTime());

        TrackerId tracker2 = new TrackerId();
        tracker2.setVehicle(peugeot);
        tracker2.setTrackerId(UUID.fromString("7c4ff599-6653-46d1-94b4-36c54a79b8bb"));
        tracker2.setDestroyedDate(cal.getTime());

        TrackerId tracker3 = new TrackerId();
        tracker3.setVehicle(peugeot);
        tracker3.setTrackerId(UUID.fromString("c95494ba-60d9-442b-8114-e61fe5afcffa"));

        trackerIdFacade.save(tracker1);
        trackerIdFacade.save(tracker2);
        trackerIdFacade.save(tracker3);
    }
}

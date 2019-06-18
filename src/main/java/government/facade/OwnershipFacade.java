package government.facade;

import government.dto.OwnershipDto;
import government.mapper.OwnershipMapper;
import government.model.Ownership;
import government.model.User;
import government.model.Vehicle;
import government.repository.OwnershipRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OwnershipFacade {

    @Inject
    private OwnershipRepository ownershipRepository;

    @Inject
    private OwnershipMapper mapper;

    public List<OwnershipDto> findAll(Vehicle vehicle) {
        return mapper.ownershipsToOwnershipDtos(ownershipRepository.findAll(vehicle));
    }

    public void transferVehicleToUser(Vehicle vehicle, User user) {
        // Retrieve the current ownership for this vehicle
        Optional<Ownership> currentOwnership = ownershipRepository.findCurrent(vehicle);

        // Set the endDate on the current ownership
        if(currentOwnership.isPresent()) {
            currentOwnership.get().setEndDate(new Date());
            ownershipRepository.save(currentOwnership.get());
        }

        // Create a new ownership
        Ownership ownership = new Ownership();
        ownership.setVehicle(vehicle);
        ownership.setUser(user);

        ownershipRepository.save(ownership);
    }
    public List<Ownership> findByUser(User user){
        return ownershipRepository.findAll(user);
    }
    public List<Ownership> findByUserAndDate(User user,Date start,Date end){
        return ownershipRepository.findByUserAndDate(user,start,end);
    }
    public List<Ownership> findByUserId(Long id){
        return ownershipRepository.findAllByUserId(id);
    }
}

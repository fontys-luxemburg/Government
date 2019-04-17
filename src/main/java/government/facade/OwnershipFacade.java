package government.facade;

import government.model.Ownership;
import government.model.Vehicle;
import government.repository.OwnershipRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class OwnershipFacade {

    @Inject
    private OwnershipRepository ownershipRepository;

    public List<Ownership> findAll(Vehicle vehicle) {
        return ownershipRepository.findAll(vehicle);
    }
}

package government.facade;

import government.dto.OwnershipDto;
import government.mapper.OwnershipMapper;
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

    @Inject
    private OwnershipMapper mapper;

    public List<OwnershipDto> findAll(Vehicle vehicle) {
        return mapper.ownershipsToOwnershipDtos(ownershipRepository.findAll(vehicle));
    }
}

package government.facade;

import government.model.Vehicle;
import government.repository.VehicleRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class VehicleFacade implements BaseFacade<Vehicle, Long> {

    @Inject
    VehicleRepository repository;

    @Override
    public Optional<Vehicle> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<Vehicle> findByRegistrationID(String registrationID) {
        return repository.findByRegistrationID(registrationID);
    }

    @Override
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    @Override
    public Vehicle save(Vehicle entity) {
        repository.save(entity);
        return entity;
    }
}

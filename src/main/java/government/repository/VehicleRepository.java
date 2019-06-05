package government.repository;

import government.model.Vehicle;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class VehicleRepository extends CrudRepository<Vehicle, Long> {

    @PostConstruct
    private void init() {
        setEntityClass(Vehicle.class);
    }

    public List<Vehicle> search(String searchTerm) {
        Query query = entityManager.createQuery("select v from Vehicle v where v.registrationID like :term or v.brand like :term");
        query.setParameter("term", "%" + searchTerm + "%");

        return query.getResultList();
    }

    public Optional<Vehicle> findByRegistrationID(String registrationID) {
        Query query = entityManager.createQuery("select v from Vehicle v where v.registrationID = :registrationID");
        query.setParameter("registrationID", registrationID);

        try {
            return Optional.of((Vehicle) query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}

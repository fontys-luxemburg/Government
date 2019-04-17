package government.repository;

import government.model.Ownership;
import government.model.User;
import government.model.Vehicle;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class OwnershipRepository extends CrudRepository<Ownership, Long> {

    @PostConstruct
    private void init() {
        setEntityClass(Ownership.class);
    }

    public List<Ownership> findAll(User user) {
        Query query = entityManager.createQuery("select o from Ownership o where o.user.id = :user_id");
        query.setParameter("user_id", user.getId());
        return query.getResultList();
    }

    public List<Ownership> findAll(Vehicle vehicle) {
        Query query = entityManager.createQuery("select o from Ownership o where o.vehicle.id = :vehicle_id");
        query.setParameter("vehicle_id", vehicle.getId());
        return query.getResultList();
    }
}

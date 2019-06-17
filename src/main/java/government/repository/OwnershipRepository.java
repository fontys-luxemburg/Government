package government.repository;

import government.model.Ownership;
import government.model.User;
import government.model.Vehicle;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public List<Ownership> findAllByUserId(Long id) {
        Query query = entityManager.createQuery("select o from Ownership o where o.user.id = :user_id");
        query.setParameter("user_id", id);
        return query.getResultList();
    }

    public List<Ownership> findAll(Vehicle vehicle) {
        Query query = entityManager.createQuery("select o from Ownership o where o.vehicle.id = :vehicle_id order by o.createdAt desc");
        query.setParameter("vehicle_id", vehicle.getId());
        return query.getResultList();
    }

    public Optional<Ownership> findCurrent(Vehicle vehicle) {
        Query query = entityManager.createQuery("select o from Ownership o where o.vehicle.id = :vehicle_id and o.endDate = null");
        query.setParameter("vehicle_id", vehicle.getId());

        try {
            return Optional.of((Ownership) query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public List<Ownership> findByUserAndDate(User user, Date start, Date endDate) {
        Query query = entityManager.createQuery("select o from Ownership o where o.user.id = :user_id and o.createdAt between :start and :endDate");
        query.setParameter("user_id", user.getId());
        query.setParameter("start",start);
        query.setParameter("endDate",endDate);
        return query.getResultList();
    }
}

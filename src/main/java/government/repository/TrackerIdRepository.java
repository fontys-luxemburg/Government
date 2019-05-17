package government.repository;

import government.model.TrackerId;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class TrackerIdRepository extends CrudRepository<TrackerId, Long> {

    @PostConstruct
    private void init() {
        setEntityClass(TrackerId.class);
    }

    public Optional<TrackerId> findByTrackerID(UUID trackerid){
        Query query = entityManager.createQuery("select t from TrackerId t where t.trackerId = :trackerId");
        query.setParameter("trackerId", trackerid);

        try {
            return Optional.of((TrackerId) query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public List<TrackerId> findByVehicleId(Long id) {
        Query query = entityManager.createQuery("select t from TrackerId t where t.vehicle.id = :vehicleId");
        query.setParameter("vehicleId", id);

        try{
            return query.getResultList();
        } catch (NoResultException e){
            return null;
        }
    }

    public Optional<TrackerId> findLastTrackerByVehicle(String vehicleId) {
        Query query = entityManager.createQuery("select t from TrackerId t where t.id = (select max(t2.id) from TrackerId t2 where t2.vehicle.registrationID = :vehicleId)");
        query.setParameter("vehicleId", vehicleId);

        try{
            return Optional.of((TrackerId) query.getSingleResult());
        } catch (NoResultException e){
            return Optional.empty();
        }
    }
}

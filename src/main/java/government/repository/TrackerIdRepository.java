package government.repository;

import government.model.TrackerId;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;
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
}

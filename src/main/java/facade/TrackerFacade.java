package facade;

import model.TrackerId;
import repository.TrackerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class TrackerFacade implements BaseFacade<TrackerId, Long> {

    @Inject
    TrackerRepository repository;

    @Override
    public Optional<TrackerId> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<TrackerId> findByTrackerID(UUID trackerid){
        return repository.findByTrackerID(trackerid);
    }

    @Override
    public List<TrackerId> findAll() {
        return repository.findAll();
    }

    @Override
    public TrackerId save(TrackerId entity) {
        repository.save(entity);
        return entity;
    }
}

package government.repository;

import government.model.RushRate;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RushRateRepository extends CrudRepository<RushRate, Long> {

    @PostConstruct
    public void init() {
        setEntityClass(RushRate.class);
    }
}

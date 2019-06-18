package government.repository;

import government.model.Rate;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RateRepository extends CrudRepository<Rate, Long> {

    @PostConstruct
    private void init() {
        setEntityClass(Rate.class);
    }

}

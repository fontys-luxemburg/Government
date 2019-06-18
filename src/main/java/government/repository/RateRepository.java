package government.repository;

import government.model.Rate;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class RateRepository extends CrudRepository<Rate, Long> {

    @PostConstruct
    private void init() {
        setEntityClass(Rate.class);
    }

    @Override
    public List<Rate> findAll() {
        return entityManager.createQuery("select r from Rate r order by r.createdAt desc").getResultList();
    }

    public Rate rateForDate(Date date) {
        Query query = entityManager.createQuery("select r from Rate r where r.createdAt <= :date order by r.createdAt desc");
        query.setParameter("date", date);

        List<Rate> rates =  query.getResultList();

        if (rates.size() > 0) {
            return rates.get(0);
        }

        return null;
    }

}

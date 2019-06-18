package government.repository;

import government.model.Invoice;
import government.model.Ownership;

import javax.annotation.PostConstruct;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class InvoiceRepository extends CrudRepository<Invoice,Long>{
    @PostConstruct
    private void init() {
        setEntityClass(Invoice.class);
    }
    public Optional<Invoice> findByRegistrationId(String registrationId, Date from, Date till){
        Query query = generateQueryWithFromAndTill("select i from Invoice i where i.vehicle.registrationID = :registrationId and i.startDate = :start and i.endDate =:till"
        ,from,till);
        query.setParameter("registrationId", registrationId);
        try {
            return Optional.of((Invoice) query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
    public Optional<Invoice> findByUserId(Long user_id, Date from, Date till){
        Query query = generateQueryWithFromAndTill("select i from Invoice i where i.user.id = :user_Id and i.startDate = :startDate and i.endDate =:till",
                from,till);
        query.setParameter("user_Id", user_id);
        try {
            return Optional.of((Invoice) query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
    public List<Invoice> getAllInvoicesByUser(Long user_id){
        Query query = entityManager.createQuery("select i from Invoice i where i.user.id = :user_id");
        query.setParameter("user_id", user_id);
        return query.getResultList();
    }

    private Query generateQueryWithFromAndTill(String queryString, Date startDate, Date endDate){
        Query query = entityManager.createQuery(queryString);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query;
    }

}

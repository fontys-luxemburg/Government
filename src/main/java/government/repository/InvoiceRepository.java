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
        Query query = generateQueryWithFromAndTill("select i from Invoice i where i.vehicle.registrationID = :registrationId and i.from = :start and i.till =:till"
        ,from,till);
        query.setParameter("registrationId", registrationId);
        try {
            return Optional.of((Invoice) query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
    public Optional<Invoice> findByUserId(Long user_id, Date from, Date till){
        Query query = generateQueryWithFromAndTill("select i from Invoice i where i.user.id = :user_Id and i.from = :start and i.till =:till",
                from,till);
        query.setParameter("user_Id", user_id);
        try {
            return Optional.of((Invoice) query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
    public List<Invoice> getAllInvoicesByUser(Long user_id){
        Query query = entityManager.createQuery("select i from Invoice i where i.user.id = :user_Id");
        query.setParameter("user_Id", user_id);
        return query.getResultList();
    }

    private Query generateQueryWithFromAndTill(String queryString, Date from, Date till){
        Query query = entityManager.createQuery(queryString);
        query.setParameter("start", from);
        query.setParameter("till", till);
        return query;
    }

}

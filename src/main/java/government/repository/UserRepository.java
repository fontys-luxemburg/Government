package government.repository;

import government.model.User;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class UserRepository extends CrudRepository<User, Long> {

    @PostConstruct
    private void init() {
        setEntityClass(User.class);
    }

    public Optional<User> findUserByEmail(String email) {
        Query query = entityManager.createQuery("select u from User u where u.email = :email");
        query.setParameter("email", email);

        try {
            return Optional.of((User) query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public List<User> search(String searchTerm) {
        Query query = entityManager.createQuery("select u from User u where u.name like :term or u.email like :term");
        query.setParameter("term", "%" + searchTerm + "%");

        return query.getResultList();
    }
}

package me.mike.aims.repository.jpa;

import me.mike.aims.model.entity.User;
import me.mike.aims.model.search.UserSearchRequest;
import me.mike.aims.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Michael Keith
 */
@Repository
public class UserJpaRepository implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override @Transactional(propagation = Propagation.MANDATORY)
    public User create(final User user) {
        entityManager.persist(user);
        return user;
    }

    @Override @Transactional(propagation = Propagation.MANDATORY, readOnly = true)
    public User readById(final UUID id) {
        final CriteriaBuilder     builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<User> query   = builder.createQuery(User.class);
        final Root<User>          root    = query.from(User.class);

        return entityManager
                .createQuery(query.where(builder.equal(root.<String>get("id"), id.toString())))
                .getSingleResult();
    }

    @Override @Transactional(propagation = Propagation.MANDATORY, readOnly = true)
    public Optional<User> findByUsername(String username) {
        final CriteriaBuilder     builder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<User> query   = builder.createQuery(User.class);
        final Root<User>          root    = query.from(User.class);

        final List<User> results = entityManager
                .createQuery(query.where(builder.equal(root.<String>get("username"), username)))
                .getResultList();

        if (results.size() > 1)
            throw new NonUniqueResultException(String.format("Username [%s] is not unique!", username));

        return results.isEmpty() ?
                Optional.empty() : Optional.of(results.get(0));
    }

    @Override @Transactional(propagation = Propagation.MANDATORY, readOnly = true)
    public List<User> search(UserSearchRequest searchRequest) {
        // 1. Setup JPA Query Generations.
        final List<Predicate>     predicates = new ArrayList<>();
        final CriteriaBuilder builder    = entityManager.getCriteriaBuilder();
        final CriteriaQuery<User> query      = builder.createQuery(User.class);
        final CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
        final Root<User> job        = query.from(User.class);

        // TODO

        return null;
    }

    @Override @Transactional(propagation = Propagation.MANDATORY)
    public User update(final User user) {
        return entityManager.merge(user);
    }
}

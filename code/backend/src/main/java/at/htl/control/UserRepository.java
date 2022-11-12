package at.htl.control;

import java.util.List;
import at.htl.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@ApplicationScoped
public class UserRepository {
    @Inject
    EntityManager em;

    public User save(at.htl.entity.User user) {
        return em.merge(user);
    }

    public List<User> findAll() {
        TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
        return query.getResultList();
    }

    public User findById(long id) {
        return em.find(User.class, id);
    }

    public List<User> findByUserName(String userName) {
        TypedQuery<User> query = em
                .createNamedQuery("User.findByUserName", User.class)
                .setParameter("NAME", userName);
        return query.getResultList();
    }
}

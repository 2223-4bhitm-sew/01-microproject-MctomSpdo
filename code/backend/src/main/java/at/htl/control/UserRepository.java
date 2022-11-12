package at.htl.control;

import java.util.List;
import at.htl.entity.User;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@ApplicationScoped
public class UserRepository {
    @Inject
    EntityManager em;

    @Inject
    Logger logger;

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

    public List<User> findByEmail(String email) {
        TypedQuery<User> query = em
                .createNamedQuery("User.findByEmail", User.class)
                .setParameter("EMAIL", email);
        return query.getResultList();
    }

    public User merge(User user) {
        return em.merge(user);
    }

    /**
     * deletes a given User from the db
     * @param user User to delete
     * @return returns true if deleted, false otherwise
     */
    public boolean deleteUser(User user) {
        if(user == null) return false;
        em.remove(user);
        return true;
    }

    /**
     * deletes a User that has the given ID
     * @param id id for the user
     * @return returns true if deleted, false otherwise
     */
    public boolean deleteUserById(long id) {
        var user = em.find(User.class, id);
        logger.info(user);
        return deleteUser(user);
    }
}

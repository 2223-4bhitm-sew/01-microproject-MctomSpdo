package at.htl.control;

import at.htl.entity.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class UserRepository {
    @Inject
    EntityManager em;

    public User save(at.htl.entity.User user) {
        return em.merge(user);
    }
}

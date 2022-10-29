package at.htl.control;

import at.htl.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class PersonRepository {

    @Inject
    EntityManager em;

    public Person save(Person person) {
        return em.merge(person);
    }


}

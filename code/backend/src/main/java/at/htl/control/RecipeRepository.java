package at.htl.control;

import at.htl.entity.Recipe;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class RecipeRepository {

    @Inject
    EntityManager em;

    @Inject
    Logger logger;

    public Recipe save(Recipe recipe) {
        return em.merge(recipe);
    }

    public List<Recipe> findAll() {
        TypedQuery<Recipe> query = em.createQuery("Recipe.findAll", Recipe.class);
        return query.getResultList();
    }
}

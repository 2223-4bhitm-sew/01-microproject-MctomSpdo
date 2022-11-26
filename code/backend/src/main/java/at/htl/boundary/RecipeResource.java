package at.htl.boundary;

import at.htl.control.RecipeRepository;
import at.htl.entity.Recipe;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/recipe")
public class RecipeResource {
    @Inject
    Logger logger;

    @Inject
    RecipeRepository recipeRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Recipe recipe, @Context UriInfo uriInfo) {
        Recipe saved = recipeRepository.save(recipe);
        URI location = uriInfo
                .getAbsolutePathBuilder()
                .path("" + saved.getId())
                .build();
        return Response.created(location).build();
    }
}

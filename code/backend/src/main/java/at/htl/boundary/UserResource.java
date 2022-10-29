package at.htl.boundary;

import at.htl.entity.Person;
import at.htl.entity.User;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Path("/user")
public class UserResource {

    @Inject
    Logger logger;

    private List<User> users = new LinkedList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> findAll() {
        return users;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(User user) {
        users.add(user);
        return Response.created(null).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(Person person) {
        if(users.size() > 0) {
            users.remove(person);
        }
        return Response.noContent().build();
    }
}

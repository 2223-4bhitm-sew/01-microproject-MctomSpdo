package at.htl.boundary;

import at.htl.control.UserRepository;
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

    @Inject
    UserRepository userRepository;

    private List<User> users = new LinkedList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GET
    @Path("id")
    @Produces(MediaType.APPLICATION_JSON)
    public User findById(
            @PathParam("id") long id
    ) {
        return userRepository.findById(id);
    }

    @GET
    @Path("username")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> findById(
            @QueryParam("username") String username
    ) {
        return userRepository.findByUserName(username);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(User user) {
        users.add(user);
        return Response.created(null).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(User user) {
        if(users.size() > 0) {
            users.remove(user);
        }
        return Response.noContent().build();
    }
}

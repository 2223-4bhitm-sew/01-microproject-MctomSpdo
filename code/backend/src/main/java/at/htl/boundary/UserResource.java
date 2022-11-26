package at.htl.boundary;

import at.htl.control.UserMapper;
import at.htl.control.UserRepository;
import at.htl.entity.User;
import at.htl.entity.UserDTO;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

@Path("/user")
public class UserResource {

    @Inject
    Logger logger;

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDTO> findAll() {
        var list = userRepository.findAll();
        var dtoList = new LinkedList<UserDTO>();

        list.forEach((user -> dtoList.add(userMapper.UserToDTO(user))));

        return dtoList;
    }

    @GET
    @Path("{id}")
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

    @GET
    @Path("email")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> findByEmail(
            @QueryParam("email") String email
    ) {
        return userRepository.findByEmail(email);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(User user, @Context UriInfo uriInfo) {
        User saved = userRepository.save(user);
        logger.info(user.getUsername() + " was created");
        URI location = uriInfo
                .getAbsolutePathBuilder()
                .path("" + saved.getId())
                .build();
        return Response.created(location).build();
    }

    @PATCH
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response patch (User user) {
        userRepository.merge(user);
        return Response.accepted().build();
    }

    @DELETE
    @Transactional
    @Consumes(MediaType.TEXT_PLAIN)
    public Response delete(long id) {
        if(userRepository.deleteUserById(id)) {
            return Response.noContent().build();
        }
        return Response.notModified().build();
    }
}

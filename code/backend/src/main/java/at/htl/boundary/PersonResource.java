package at.htl.boundary;

import at.htl.entity.Person;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Path("/person")
public class PersonResource {

    @Inject
    Logger logger;

    private List<Person> persons = new LinkedList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> findAll() {
        return persons;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Person person) {
        persons.add(person);
        return Response.created(null).build();
    }

    @PATCH
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(String firstName) {

        logger.info(persons);
        logger.info(firstName);
        Person foundPerson = persons
                .stream()
                .filter(fn -> fn.getFirstName().equals(firstName))
                .findFirst()
                .get();
        logger.info(foundPerson.getFirstName());
        //Person foundPerson = persons.get(0);
        //assert foundPerson != null;
        foundPerson.setFirstName("updated");
//        if (foundPerson.isEmpty()) {
//            logger.info("is empty");
//        } else {
//            logger.info("is not empty");
//        }
        return Response.ok(foundPerson).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(Person person) {
        if (persons.size() > 0) {
            persons.remove(0);
        }
        return Response.noContent().build();
    }
}
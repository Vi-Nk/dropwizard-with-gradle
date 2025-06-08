package dev.vink.example.resources;

import java.util.List;

import dev.vink.example.data.Person;
import dev.vink.example.data.PersonDatabase;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/person")
public class PersonService {

    public PersonService() {

    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam("id") int id) {
        return PersonDatabase.getById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> listPersons() {
        return PersonDatabase.getAll();
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) {
        boolean result = PersonDatabase.addPerson(person);
        if (result) {
            return Response.accepted().build();
        }
        return Response.notModified().build();
    }

}

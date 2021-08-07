package com.example.demo.hundreddaysofjava;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;

/**
 * Day 76 - Creating a REST server with JAX-RS (and Quarkus as runtime)
 */
@Path("/person")
public class Day076 {

    // To start the server, run:
    // mvn compile quarkus:dev

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPeople() {
        return List.of(
                new Person("1", "Ozzy Osbourne", LocalDate.of(1948, 12, 3)),
                new Person("2", "Tony Iommi", LocalDate.of(1948, 2, 19)),
                new Person("3", "Geezer Butler", LocalDate.of(1948, 7, 19)),
                new Person("4", "Bill Ward", LocalDate.of(1948, 5, 5))
        );
    }

    public record Person(String id, String name, LocalDate dateOfBirth) {
    }
}

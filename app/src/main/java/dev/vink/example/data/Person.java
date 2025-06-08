package dev.vink.example.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

    private String firstName;
    private String lastName;
    private String email;
    private int id;

    @JsonCreator
    public Person(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName,
            @JsonProperty("email") String email, @JsonProperty("id") int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
    }

    @JsonProperty
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty
    public String getLastName() {
        return lastName;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

}

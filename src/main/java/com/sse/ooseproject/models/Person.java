package com.sse.ooseproject.models;

import jakarta.persistence.*;

@MappedSuperclass
public class Person {
    // Entities or MappedSuperclass models in Spring require an id. The @GeneratedValue annotation makes sure
    // that the id is automatically increased when inserting new objects into the database.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private String email;

    // TODO add more attributes.

    /**
     * A Person object. Spring requires an empty constructor. Do not change this but rather implement another
     * plausible constructor.
     */
    public Person() {}

    // TODO add a plausible constructor.

    // TODO add getter and setter methods.

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

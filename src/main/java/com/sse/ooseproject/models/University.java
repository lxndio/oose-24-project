package com.sse.ooseproject.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    @OneToMany(mappedBy = "university")
    private List<Student> students;
    @OneToMany(mappedBy = "university")
    private List<Building> buildings;
    @OneToMany(mappedBy = "university")
    private List<Employee> employees;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

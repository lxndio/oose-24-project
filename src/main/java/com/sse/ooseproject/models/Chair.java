package com.sse.ooseproject.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Chair extends OrganizationalUnit {
    @ManyToOne
    @JoinColumn(name = "institute_id")
    private Institute institute;
    @OneToOne
    @JoinColumn(name = "owner_id")
    private Employee owner;
    @OneToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(mappedBy = "chair")
    private List<Course> courses;

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }
}

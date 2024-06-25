package com.sse.ooseproject.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "chair")
public class Chair extends OrganizationalUnit {

    @ManyToOne
    @JoinColumn(name = "institute_id")
    private Institute institute;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Employee chairOwner;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(mappedBy = "chair")
    private List<Course> courses;

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public Employee getChairOwner() {
        return chairOwner;
    }

    public void setChairOwner(Employee chairOwner) {
        this.chairOwner = chairOwner;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
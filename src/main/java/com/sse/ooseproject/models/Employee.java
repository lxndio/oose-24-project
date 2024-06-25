package com.sse.ooseproject.models;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "employee")
public class Employee extends Person{

    private String staffNr;
    private boolean isProfessor;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @OneToMany(mappedBy = "employee")
    private List<TeachingShift> teachingShifts;


    public Employee() {}

    public Employee(String firstName, String lastName, String email, String staffNr, boolean isProfessor) {
        super(firstName, lastName, email);
        this.staffNr = staffNr;
        this.isProfessor = isProfessor;
    }

    public String getStaffNr(){
        return staffNr;
    }

    public void setStaffNr(String staffNr) {
        this.staffNr = staffNr;
    }

    public boolean isProfessor() {
        return isProfessor;
    }

    public void setProfessor(boolean professor) {
        this.isProfessor = professor;
    }
}

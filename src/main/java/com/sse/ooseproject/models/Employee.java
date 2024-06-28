package com.sse.ooseproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends Person{
    //Properties
    private int staffNr;
    private boolean isProfessor;
    @ManyToOne
    @JoinColumn(name="university_id")
    private University university;

    //No-argument constructor
    public Employee(){
        super();
    }

    //Constructor
    public Employee(String firstName, String lastName, String email, int staffNr, boolean isProfessor, University university) {
        super(firstName, lastName, email);
        this.staffNr = staffNr;
        this.isProfessor = isProfessor;
        this.university = university;
    }

    //Methods
    public int getStaffNr() {
        return staffNr;
    }
    public void setStaffNr(int staffNr) {
        this.staffNr = staffNr;
    }

    public Boolean getIsProfessor() {
        return isProfessor;
    }
    public void setIsProfessor(boolean isProfessor) {
        this.isProfessor = isProfessor;
    }

    public University getUniversity() {
        return university;
    }
    public void setUniversity(University university) {
        this.university = university;
    }
}

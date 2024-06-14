package com.sse.ooseproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends Person{
    //Properties
    private int staffNr;
    private boolean isProfessor;

    //No-argument constructor
    public Employee(){
        super();
    }

    //Constructor
    public Employee(String firstName, String lastName, String emailAddress, int staffNr, boolean isProfessor) {
        super(firstName, lastName, emailAddress);
        this.staffNr = staffNr;
        this.isProfessor = isProfessor;
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
}

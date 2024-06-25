package com.sse.ooseproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends Person {
    private int staffNr;
    private int isProfessor;

    public int getStaffNr() {
        return staffNr;
    }

    public void setStaffNr(int staffNr) {
        this.staffNr = staffNr;
    }

    public int getIsProfessor() {
        return isProfessor;
    }

    public void setIsProfessor(int isProfessor) {
        this.isProfessor = isProfessor;
    }
}

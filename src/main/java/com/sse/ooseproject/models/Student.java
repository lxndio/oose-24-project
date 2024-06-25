package com.sse.ooseproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends Person{
    //Properties
    private int matNr;
    private String studySubject;

    //No-argument constructor
    public Student(){
        super();
    }

    //Constructor
    public Student(String firstName, String lastName, String emailAddress, int matNr, String studySubject) {
        super(firstName, lastName, emailAddress);
        this.matNr = matNr;
        this.studySubject = studySubject;
    }

    //Methods
    public int getMatNr(){
        return matNr;
    }
    public void setMatNr(int matNr) {
        this.matNr = matNr;
    }

    public String getStudySubject(){
        return studySubject;
    }
    public void setStudySubject(String studySubject) {
        this.studySubject = studySubject;
    }
}

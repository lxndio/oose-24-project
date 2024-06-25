package com.sse.ooseproject.models;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student extends Person{
    private int matNr;
    private String studySubject;

    public int getMatNr() {
        return matNr;
    }

    public void setMatNr(int matNr) {
        this.matNr = matNr;
    }

    public String getStudySubject() {
        return studySubject;
    }

    public void setStudySubject(String studySubject) {
        this.studySubject = studySubject;
    }
}

package com.sse.ooseproject.models;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "student")
public class Student extends Person{
    // Note: This class does not need its own id attribute as that will be derived.

    private String matNr;
    private String studySubject;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;

    public Student(){}

    public Student(String firstName, String lastName, String email, String matNr, String studySubject) {
        super(firstName, lastName, email);
        this.matNr = matNr;
        this.studySubject = studySubject;
    }

    public String getMatNr() {
        return matNr;
    }

    public void setMatNr(String matNr) {
        this.matNr = matNr;
    }

    public String getStudySubject() {
        return studySubject;
    }

    public void setStudySubject(String studySubject) {
        this.studySubject = studySubject;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}

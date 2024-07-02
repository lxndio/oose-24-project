package com.sse.ooseproject.models;

import jakarta.persistence.*;

@Entity
public class Enrollment {
    private String semester;
    @Id
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}

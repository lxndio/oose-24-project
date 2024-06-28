package com.sse.ooseproject.models;

import jakarta.persistence.*;

@Entity
@Table(name = "enrollment")
public class Enrollment {
    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String semester;
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    //No-argument constructor
    public Enrollment(){}

    //Constructor
    public Enrollment(String semester, Course course, Student student) {
        this.semester = semester;
        this.course = course;
        this.student = student;
    }

    //Methods
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

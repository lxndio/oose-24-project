package com.sse.ooseproject.models;

import jakarta.persistence.*;

@Entity
public class Enrollment {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Embedded
    private EnrollmentId enrollmentId;
    private String semester;

    @ManyToOne
    @MapsId("course_id")
    private Course course;

    @ManyToOne
    @MapsId("student_id")
    private Student student;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EnrollmentId getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(EnrollmentId enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

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

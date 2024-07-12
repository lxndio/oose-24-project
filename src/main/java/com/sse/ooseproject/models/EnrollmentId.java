package com.sse.ooseproject.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;

import java.io.Serializable;

@Embeddable
public class EnrollmentId implements Serializable {
    @JoinColumn(name = "course")
    private long course_id;
    @JoinColumn(name = "student")
    private long student_id;

    public EnrollmentId(long course_id, long student_id) {
        this.course_id = course_id;
        this.student_id = student_id;
    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public EnrollmentId() {

    }
}

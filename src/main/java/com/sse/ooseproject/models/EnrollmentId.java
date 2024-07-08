package com.sse.ooseproject.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Embeddable
public class EnrollmentId {
    @Id
    @JoinColumn(name = "course_id")
    private long course_id;
    @Id
    @JoinColumn(name = "student_id")
    private long student_id;

    public EnrollmentId(long course_id, long student_id) {
        this.course_id = course_id;
        this.student_id = student_id;
    }

    public EnrollmentId() {

    }
}

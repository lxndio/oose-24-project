package com.sse.ooseproject.models;

import jakarta.persistence.*;

@Entity
@Table(name = "teaching_shift")
public class TeachingShift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}


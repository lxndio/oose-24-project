package com.sse.ooseproject.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Course {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    private String name;
    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;
    @OneToMany(mappedBy = "course")
    private List<RoomOccupancy> roomOccupancies;
    @OneToMany(mappedBy = "course")
    private List<TeachingShift> teachingShifts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

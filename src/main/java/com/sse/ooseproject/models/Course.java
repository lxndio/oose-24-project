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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public List<RoomOccupancy> getRoomOccupancies() {
        return roomOccupancies;
    }

    public void setRoomOccupancies(List<RoomOccupancy> roomOccupancies) {
        this.roomOccupancies = roomOccupancies;
    }

    public List<TeachingShift> getTeachingShifts() {
        return teachingShifts;
    }

    public void setTeachingShifts(List<TeachingShift> teachingShifts) {
        this.teachingShifts = teachingShifts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

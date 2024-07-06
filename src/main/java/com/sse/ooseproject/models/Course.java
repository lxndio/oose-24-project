package com.sse.ooseproject.models;

import jakarta.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "chair_id")
    private Chair chair;

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }

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

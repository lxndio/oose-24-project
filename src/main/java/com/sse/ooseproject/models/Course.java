package com.sse.ooseproject.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "course")
    private List<RoomOccupancy> roomOccupancies;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "course")
    private List<TeachingShift> teachingShifts;

    @ManyToOne
    @JoinColumn(name = "chair_id")
    private Chair chair;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RoomOccupancy> getRoomOccupancies() {
        return roomOccupancies;
    }

    public void setRoomOccupancies(List<RoomOccupancy> roomOccupancies) {
        this.roomOccupancies = roomOccupancies;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public List<TeachingShift> getTeachingShifts() {
        return teachingShifts;
    }

    public void setTeachingShifts(List<TeachingShift> teachingShifts) {
        this.teachingShifts = teachingShifts;
    }

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }
}


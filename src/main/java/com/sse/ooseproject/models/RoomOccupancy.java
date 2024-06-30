package com.sse.ooseproject.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class RoomOccupancy {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    private LocalDateTime occupancyTime;

    public Course getCourseId() {
        return course;
    }

    public void setCourseId(Course course) {
        this.course = course;
    }

    public Room getRoomId() {
        return room;
    }

    public void setRoomId(Room room) {
        this.room = room;
    }

    public LocalDateTime getOccupancyTime() {
        return occupancyTime;
    }

    public void setOccupancyTime(LocalDateTime occupancyTime) {
        this.occupancyTime = occupancyTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

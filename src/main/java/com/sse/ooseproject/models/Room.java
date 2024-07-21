package com.sse.ooseproject.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
    private String number;
    private int seats;
    private boolean isAuditorium;
    @OneToMany(mappedBy = "room")
    List<RoomOccupancy> roomOccupancies;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isAuditorium() {
        return isAuditorium;
    }

    public void setAuditorium(boolean auditorium) {
        isAuditorium = auditorium;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

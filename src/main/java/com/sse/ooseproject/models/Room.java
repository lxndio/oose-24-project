package com.sse.ooseproject.models;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "room")
public class Room {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String number;
    private int seats;
    private boolean isAuditorium;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(mappedBy = "room")
    private List<RoomOccupancy> occupancies;

}

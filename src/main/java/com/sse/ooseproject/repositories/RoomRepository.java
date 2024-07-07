package com.sse.ooseproject.repositories;

import com.sse.ooseproject.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByOrderByIdAsc();
    List<Room> findByOrderByNumberAsc();
    List<Room> findByOrderBySeatsAsc();
    //List<Room> findByOrderByAuditoriumAsc();
    List<Room> findByOrderByBuildingIdAsc();
    List<Room> findByOrderByIdDesc();
    List<Room> findByOrderByNumberDesc();
    List<Room> findByOrderBySeatsDesc();
    //List<Room> findByOrderByAuditoriumDesc();
    List<Room> findByOrderByBuildingIdDesc();
}

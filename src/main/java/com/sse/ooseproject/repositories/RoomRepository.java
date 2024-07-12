package com.sse.ooseproject.repositories;

import com.sse.ooseproject.models.Room;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByOrderByIdAsc();
    List<Room> findByOrderByNumberAsc();
    List<Room> findByOrderBySeatsAsc();
    List<Room> findByOrderByIsAuditoriumAsc();
    List<Room> findByOrderByBuildingAsc();
    List<Room> findByOrderByIdDesc();
    List<Room> findByOrderByNumberDesc();
    List<Room> findByOrderBySeatsDesc();
    List<Room> findByOrderByIsAuditoriumDesc();
    List<Room> findByOrderByBuildingDesc();

    //List<Room> findAll(Sort by, String isAuditorium);
}

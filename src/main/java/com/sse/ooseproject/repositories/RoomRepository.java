package com.sse.ooseproject.repositories;

import com.sse.ooseproject.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}

package com.sse.ooseproject.repositories;

import com.sse.ooseproject.models.Chair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChairRepository extends JpaRepository<Chair, Long> {
}

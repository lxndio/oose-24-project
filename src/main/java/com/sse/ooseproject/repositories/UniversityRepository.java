package com.sse.ooseproject.repositories;

import com.sse.ooseproject.models.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long> {
}

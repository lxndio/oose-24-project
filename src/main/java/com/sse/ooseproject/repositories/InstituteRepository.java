package com.sse.ooseproject.repositories;

import com.sse.ooseproject.models.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstituteRepository extends JpaRepository<Institute, Long> {
    List<Institute> findAllByUniversityId(int universityId);
}

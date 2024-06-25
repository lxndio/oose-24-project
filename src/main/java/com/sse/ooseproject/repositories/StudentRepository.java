package com.sse.ooseproject.repositories;

import com.sse.ooseproject.models.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface StudentRepository extends Repository<Student, Long> {
    Student findByMatNr(int matNr);
    List<Student> findAll(Sort sort);
}

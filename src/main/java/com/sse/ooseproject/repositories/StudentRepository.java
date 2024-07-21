package com.sse.ooseproject.repositories;

import com.sse.ooseproject.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // TODO add query methods.

    Student findStudentByMatNr(int matNr);
    Student findStudentById(long id);
    List<Student> findByOrderByMatNrAsc();
    List<Student> findByOrderByLastNameAsc();
    List<Student> findByOrderByFirstNameAsc();
    List<Student> findByOrderByStudySubjectAsc();
    List<Student> findByOrderByMatNrDesc();
    List<Student> findByOrderByLastNameDesc();
    List<Student> findByOrderByFirstNameDesc();
    List<Student> findByOrderByStudySubjectDesc();
}

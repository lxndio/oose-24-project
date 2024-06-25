package com.sse.ooseproject.repositories;

import com.sse.ooseproject.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findEmployeeByStaffNr(int staffNr);

    List<Employee> findByOrderByLastNameAsc();
    List<Employee> findByOrderByFirstNameAsc();
    List<Employee> findByOrderByStaffNrAsc();
    List<Employee> findByOrderByIsProfessorAsc();
    List<Employee> findByOrderByLastNameDesc();
    List<Employee> findByOrderByFirstNameDesc();
    List<Employee> findByOrderByStaffNrDesc();
    List<Employee> findByOrderByIsProfessorDesc();
}

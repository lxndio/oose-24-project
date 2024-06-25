package com.sse.ooseproject;

import com.sse.ooseproject.models.Employee;
import com.sse.ooseproject.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import java.util.Optional;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Optional<Employee> findByStaffNr(String staffNr);
    List<Employee> findByStaffNr(String staffNr);
}

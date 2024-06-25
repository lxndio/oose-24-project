package com.sse.ooseproject.repositories;

import com.sse.ooseproject.models.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface EmployeeRepository extends Repository<Employee, Long> {
    Employee findByStaffNr(int staffNr);
    List<Employee> findAll(Sort sort);
}

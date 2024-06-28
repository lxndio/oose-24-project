package com.sse.ooseproject.controllers;

import com.sse.ooseproject.repositories.EmployeeRepository;
import com.sse.ooseproject.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public String employees(Model model, @RequestParam(value = "sort_by", defaultValue = "firstName") String sortBy,
                           @RequestParam(value = "sort_asc", defaultValue = "true") boolean sortAsc) {

        Sort.Direction direction = sortAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);

        List<Employee> employees = employeeRepository.findAll(sort);
        model.addAttribute("employees", employees);

        // Returning the name of a view (found in resources/templates) as a string lets this endpoint return that view.
        return "employees";
    }
}

package com.sse.ooseproject.controllers;

import com.sse.ooseproject.models.Employee;
import com.sse.ooseproject.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Controller
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public String employees(Model model, @RequestParam(value = "sort_by", defaultValue = "staffNr", required = false) String sort_by,
                            @RequestParam(value = "sort_asc", defaultValue = "true") boolean sort_asc) {

        List<Employee> employeesSorted = Collections.emptyList();
        if(sort_asc && Objects.equals(sort_by, "staffNr")) {
            employeesSorted = employeeRepository.findByOrderByStaffNrAsc();
        }
        if(sort_asc && Objects.equals(sort_by, "lastName")) {
            employeesSorted = employeeRepository.findByOrderByLastNameAsc();
        }
        if(sort_asc && Objects.equals(sort_by, "firstName")) {
            employeesSorted = employeeRepository.findByOrderByFirstNameAsc();
        }
        if(sort_asc && Objects.equals(sort_by, "isProfessor")) {
            employeesSorted = employeeRepository.findByOrderByIsProfessorAsc();
        }
        if(!sort_asc && Objects.equals(sort_by, "staffNr")) {
            employeesSorted = employeeRepository.findByOrderByStaffNrDesc();
        }
        if(!sort_asc && Objects.equals(sort_by, "lastName")) {
            employeesSorted = employeeRepository.findByOrderByLastNameDesc();
        }
        if(!sort_asc && Objects.equals(sort_by, "firstName")) {
            employeesSorted = employeeRepository.findByOrderByFirstNameDesc();
        }
        if(!sort_asc && Objects.equals(sort_by, "isProfessor")) {
            employeesSorted = employeeRepository.findByOrderByIsProfessorDesc();
        }

        model.addAttribute("employees", employeesSorted);
        model.addAttribute("sort_asc", sort_asc);
        model.addAttribute("sort_by", sort_by);

        return "employees";
    }
}

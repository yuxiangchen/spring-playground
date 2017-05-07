package com.example;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by trainer8 on 5/7/17.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeesRepository employeesRepository;

    public EmployeeController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @JsonView(EmployeesView.EmployeesOnly.class)
    @GetMapping("")
    public Iterable<Employees> allOfEmployeeExceptSalary() {
        return this.employeesRepository.findAll();
    }
}

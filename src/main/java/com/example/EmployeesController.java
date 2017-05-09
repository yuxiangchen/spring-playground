package com.example;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by trainer8 on 5/7/17.
 */
@RestController
public class EmployeesController {
    @Autowired
    private EmployeesRepository repository;

    public EmployeesController(EmployeesRepository repository) {
        this.repository = repository;
    }

    @JsonView(EmployeesView.ManagerOnly.class)
    @GetMapping("/admin/employees")
    public Iterable<Employees> all() {
        return this.repository.findAll();
    }

    @GetMapping("/me")
    public Employees getMe(@AuthenticationPrincipal Employees employees) {
        return employees;
    }


}

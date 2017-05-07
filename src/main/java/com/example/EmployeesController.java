package com.example;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by trainer8 on 5/7/17.
 */
@RestController
public class EmployeesController {
    private EmployeesRepository repository;

    public EmployeesController(EmployeesRepository repository) {
        this.repository = repository;
    }

    @JsonView(EmployeesView.ManagerOnly.class)
    @GetMapping("/admin/employees")
    public Iterable<Employees> all() {
        return this.repository.findAll();
    }



//    @JsonView(EmployeesView.EmployeesOnly.class)
//    @GetMapping("/employees")
//    public Iterable<Employees> getEmployees() {
//        return this.repository.findAll();
//    }
//    @JsonView(EmployeesView.EmployeesOnly.class)
//    @GetMapping("/employees")
//    public Iterable<Employees> allOfEmployeeExceptSalary() {
//        return this.repository.findAll();
//    }


}

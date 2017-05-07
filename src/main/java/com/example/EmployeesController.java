package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by trainer8 on 5/7/17.
 */
@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @GetMapping("")
    public String getEmployees() {
        return "Super secret list of employees";
    }
}

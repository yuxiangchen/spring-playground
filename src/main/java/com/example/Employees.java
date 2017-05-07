package com.example;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by trainer8 on 5/7/17.
 */
@Entity
//@Data
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(EmployeesView.EmployeesOnly.class)
    private Long id;
    @JsonView(EmployeesView.EmployeesOnly.class)
    private String name;

    @JsonView(EmployeesView.ManagerOnly.class)
    private int salary;

    @JsonView(EmployeesView.EmployeesOnly.class)
    private Long managerId;

    public Employees(String name, int salary, Long managerId) {
        this.name = name;
        this.salary = salary;
        this.managerId = managerId;
    }

    public Employees() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
}

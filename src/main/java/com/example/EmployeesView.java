package com.example;

/**
 * Created by trainer8 on 5/7/17.
 */
public interface EmployeesView {
    interface EmployeesOnly {}
    interface ManagerOnly extends EmployeesOnly {}
}

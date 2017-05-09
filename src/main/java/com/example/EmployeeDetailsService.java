package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by trainer8 on 5/9/17.
 */
@Service
public class EmployeeDetailsService implements UserDetailsService {
    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employees employee = employeesRepository.findByUsername(username);
        if (employee == null) throw new UsernameNotFoundException("Username " + username + " not found");
        return employee;
    }

}

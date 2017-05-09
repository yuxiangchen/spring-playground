package com.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by trainer8 on 5/7/17.
 */
@Entity
@Data
public class Employees implements UserDetails{
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

    @Column(unique=true)
    private String username;

    @JsonIgnore
    private String password;

    private String role;


    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + this.role));
    }
//    public Employees(String name, int salary, Long managerId) {
//        this.name = name;
//        this.salary = salary;
//        this.managerId = managerId;
//    }
//
//    public Employees() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getSalary() {
//        return salary;
//    }
//
//    public void setSalary(int salary) {
//        this.salary = salary;
//    }
//
//    public Long getManagerId() {
//        return managerId;
//    }
//
//    public void setManagerId(Long managerId) {
//        this.managerId = managerId;
//    }
}

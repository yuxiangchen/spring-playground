package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by trainer8 on 4/30/17.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    EmployeeDetailsService employeeDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().mvcMatchers("/flights/**", "/math/**", "/movies/**", "/favorites/**").permitAll();
        http.authorizeRequests().mvcMatchers("/admin/**").hasRole("MANAGER");
        http.httpBasic();
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // this line is the one that changes
        auth.userDetailsService(employeeDetailsService);
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.httpBasic();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.authorizeRequests().mvcMatchers("/flights/**", "/math/**").permitAll();
//        http.authorizeRequests().mvcMatchers("/admin/**").hasRole("MANAGER");
//        http.authorizeRequests().anyRequest().authenticated();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("employee").password("my-employee-password").roles("EMPLOYEE")
//                .and()
//                .withUser("boss").password("my-boss-password").roles("MANAGER");
//    }


}

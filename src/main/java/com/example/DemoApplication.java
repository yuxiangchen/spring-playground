package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	@Profile("default")
	public CommandLineRunner seedData(EmployeesRepository employeeRepository, PasswordEncoder passwordEncoder) {
		return (args) -> {
			employeeRepository.deleteAll();

			Employees employee = new Employees();
			employee.setName("Employee");
			employee.setSalary(24);
			employee.setUsername("employee");
			employee.setPassword(passwordEncoder.encode("my-employee-password"));
			employee.setRole("EMPLOYEE");
			employeeRepository.save(employee);

			Employees boss = new Employees();
			boss.setName("Bossy Boss");
			boss.setSalary(24);
			boss.setUsername("boss");
			boss.setPassword(passwordEncoder.encode("my-boss-password"));
			boss.setRole("MANAGER");
			employeeRepository.save(boss);
		};

	}

}

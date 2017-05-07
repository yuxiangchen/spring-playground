package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	@Profile("default")
	public CommandLineRunner seedData(EmployeesRepository employeeRepository) {
		return (args) -> {
			employeeRepository.deleteAll();
			Employees employees = new Employees();
			employees.setName("Employees");
			employees.setSalary(24);
			employeeRepository.save(employees);
		};

	}

}

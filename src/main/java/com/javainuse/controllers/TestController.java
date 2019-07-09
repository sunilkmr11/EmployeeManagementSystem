package com.javainuse.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Employee;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/employees" })
public class TestController {

	private List<Employee> employees = createList();

	@GetMapping(produces = "application/json")
	public List<Employee> firstPage() {
		return employees;
	}

	@DeleteMapping(path = { "/{id}" })
	public Employee delete(@PathVariable("id") int id) {
		Employee deletedEmp = null;
		for (Employee emp : employees) {
			if (emp.getEmpId().equals(id)) {
				employees.remove(emp);
				deletedEmp = emp;
				break;
			}
		}
		return deletedEmp;
	}

	@PostMapping
	public Employee create(@RequestBody Employee user) {
		employees.add(user);
		System.out.println(employees);
		return user;
	}

	private static List<Employee> createList() {
		List<Employee> tempEmployees = new ArrayList<>();
		
		Employee emp1 = new Employee();
		emp1.setName("Sunil Kumar");
		emp1.setDesignation("Sr. Software Enegineer");
		emp1.setEmpId("1");
		emp1.setSalary(65000);

		Employee emp2 = new Employee();
		emp2.setName("Shashank Gawde");
		emp2.setDesignation("Team Lead");
		emp2.setEmpId("2");
		emp2.setSalary(75000);
		
		Employee emp3 = new Employee();
		emp3.setName("Umesh Garg");
		emp3.setDesignation("Lead Manager");
		emp3.setEmpId("3");
		emp3.setSalary(95000);
		
		Employee emp4 = new Employee();
		emp4.setName("Abdul Khan");
		emp4.setDesignation("Software Engineer");
		emp4.setEmpId("5");
		emp4.setSalary(18000);
		
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);
		tempEmployees.add(emp3);
		tempEmployees.add(emp4);
		
		return tempEmployees;
	}

}
package com.example.employeemanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@PostMapping("/save-emp")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@GetMapping("/get-all")
	List<Employee> getAllEmployee() {
		return service.getAllEmployee();
	}

	@DeleteMapping("/del-emp/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		service.deleteEmployee(id);
		return "Employee Deleted Succesffuly";
	}

	@PutMapping("/update-emp/{id}")
	public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {

		return service.updateEmployee(id, employee);
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) {
        return service.getEmployeeById(id);
	}

}
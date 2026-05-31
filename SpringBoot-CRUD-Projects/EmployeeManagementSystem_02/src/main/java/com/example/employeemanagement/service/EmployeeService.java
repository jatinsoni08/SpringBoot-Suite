package com.example.employeemanagement.service;

import java.util.List;
import com.example.employeemanagement.entity.Employee;


public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(Integer id);

	Employee updateEmployee(Integer id, Employee employee);

	void deleteEmployee(Integer id);

}

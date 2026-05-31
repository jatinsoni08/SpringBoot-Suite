package com.example.employeemanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository repository;
	
	public EmployeeServiceImpl(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	
	@Override
	public List<Employee> getAllEmployee() {
		return repository.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void deleteEmployee(Integer id) {
        repository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Integer id, Employee employee) {
		Employee emStudent = repository.findById(id).orElse(null);
		if(emStudent!= null) {
			emStudent.setEmpName(employee.getEmpName());
			emStudent.setEmpcity(employee.getEmpcity());
			emStudent.setEmpsalary(employee.getEmpsalary());
			
			return repository.save(emStudent);
		}
		return null;
	}
	
}

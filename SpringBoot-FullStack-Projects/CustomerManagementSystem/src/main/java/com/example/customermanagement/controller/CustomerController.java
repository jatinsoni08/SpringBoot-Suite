package com.example.customermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	@PostMapping("/save")
	public Customer saveAllCustomer(@RequestBody Customer customer) {
		return service.saveCustomer(customer);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable Integer id) {
		service.deleteCustomer(id);
		return "Customer Deleted Succesfully";
	}
	
	@PutMapping("/update/{id}")
		public Customer updateCustomer(@RequestBody Customer customer , @PathVariable Integer id) {
		return service.updateCustomer(id, customer);
		
	}
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer() {
		return service.getAllCustomer();
	}
	
	@GetMapping("/getCustomer/{id}")
	public Customer getCustomerById(@PathVariable Integer id ) {
		return service.getCustomerById(id);
	}
	
}

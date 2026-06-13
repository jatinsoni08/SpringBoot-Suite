package com.example.customermanagement.service;

import java.util.List;

import com.example.customermanagement.entity.Customer;

public interface CustomerService  {
	
	
	Customer saveCustomer(Customer customer);
	
	List<Customer> getAllCustomer();
	
	void deleteCustomer(Integer id);
	
	Customer getCustomerById(Integer id );
	
	Customer updateCustomer(Integer id , Customer customer);
	

}

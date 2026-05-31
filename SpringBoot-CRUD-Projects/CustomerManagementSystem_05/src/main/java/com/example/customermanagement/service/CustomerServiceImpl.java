package com.example.customermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository repository;

	public CustomerServiceImpl(CustomerRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return repository.findAll();
		}

	@Override
	public void deleteCustomer(Integer id) {
		 repository.deleteById(id);
	}

	@Override
	public Customer getCustomerById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Customer updateCustomer(Integer id, Customer customer) {
		Customer cs = repository.findById(id).orElse(null);
		if(cs != null) {
			cs.setName(customer.getName());
			cs.setCity(customer.getCity());
			cs.setMobile(customer.getMobile());
			
			return repository.save(cs);
		}
		return null;
	}

}

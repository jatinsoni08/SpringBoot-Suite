package com.example.customermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.exception.CustomerNotFoundException;
import com.example.customermanagement.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository repository;
	private final EmailService emailService;

	public CustomerServiceImpl(CustomerRepository repository, EmailService emailService) {

		this.repository = repository;
		this.emailService = emailService;
	}

	@Override
	public Customer saveCustomer(Customer customer) {

		// Email already exists check
		if (repository.existsByEmail(customer.getEmail())) {
			throw new RuntimeException("Email already registered: " + customer.getEmail());
		}

		Customer savedCustomer = repository.save(customer);

		emailService.sendEmail(customer.getEmail(), "Customer Registration Successful",
				"Hello " + customer.getName() + ", your registration has been completed successfully.");

		return savedCustomer;
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
		return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
	}

	@Override
	public Customer updateCustomer(Integer id, Customer customer) {

		Customer cs = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));

		// Same email kisi aur ke paas hai to block karo
		if (repository.existsByEmailAndIdNot(customer.getEmail(), id)) {
			throw new RuntimeException("Email already registered: " + customer.getEmail());
		}

		cs.setName(customer.getName());
		cs.setCity(customer.getCity());
		cs.setMobile(customer.getMobile());
		cs.setEmail(customer.getEmail());

		return repository.save(cs);
	}
}
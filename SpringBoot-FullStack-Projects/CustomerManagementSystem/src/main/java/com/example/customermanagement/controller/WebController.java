package com.example.customermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.customermanagement.entity.Customer;
import com.example.customermanagement.service.CustomerService;

@Controller
public class WebController {

	@Autowired
	private CustomerService service;

	// Root redirect
	@GetMapping("/")
	public String root() {
		return "redirect:/web/customers";
	}

	// Login page
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	// Home - All Customers
	@GetMapping("/web/customers")
	public String getAllCustomers(Model model) {
		model.addAttribute("customers", service.getAllCustomer());
		return "customers";
	}

	// Add Form
	@GetMapping("/web/customers/add")
	public String showAddForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "add-customer";
	}

	// Save Customer
	@PostMapping("/web/customers/save")
	public String saveCustomer(@ModelAttribute Customer customer, Model model) {
		try {
			service.saveCustomer(customer);
		} catch (RuntimeException e) {
			model.addAttribute("error", e.getMessage());
			model.addAttribute("customer", customer);
			return "add-customer";
		}
		return "redirect:/web/customers";
	}

	// Edit Form
	@GetMapping("/web/customers/edit/{id}")
	public String showEditForm(@PathVariable Integer id, Model model) {
		model.addAttribute("customer", service.getCustomerById(id));
		return "edit-customer";
	}

	// Update Customer
	@PostMapping("/web/customers/update/{id}")
	public String updateCustomer(@PathVariable Integer id, @ModelAttribute Customer customer, Model model) {
		try {
			service.updateCustomer(id, customer);
		} catch (RuntimeException e) {
			model.addAttribute("error", e.getMessage());
			model.addAttribute("customer", customer);
			return "edit-customer"; // form wapas error ke saath
		}
		return "redirect:/web/customers";
	}

	// Delete
	@GetMapping("/web/customers/delete/{id}")
	public String deleteCustomer(@PathVariable Integer id) {
		service.deleteCustomer(id);
		return "redirect:/web/customers";
	}
}
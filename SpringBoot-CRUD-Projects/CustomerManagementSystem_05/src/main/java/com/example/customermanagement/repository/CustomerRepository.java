package com.example.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customermanagement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

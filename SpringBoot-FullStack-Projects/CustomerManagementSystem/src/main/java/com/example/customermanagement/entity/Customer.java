package com.example.customermanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_table")
public class Customer {
	
	@Id
	private Integer id;
	private String name;
	private String city;
	private String mobile;
	
	@Column(unique = true) 
	private String email; 

}

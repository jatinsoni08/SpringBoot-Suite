package com.example.productmanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductService service;
	
	public ProductController(ProductService serivce) {
		this.service = serivce;
	}

	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		return service.saveAllProducts(product);
	}
	
	@GetMapping("/get-all")
	public List<Product> getAllProduct() {
		return service.getAllProducts();
	}
	
	@GetMapping("/getbyId/{pid}")
	public Product getProductById(@PathVariable Integer pid) {
		return service.getProductById(pid);
	}
	
	@DeleteMapping("/delete/{pid}")
	public String deleteProduct(@PathVariable Integer pid ) {
		service.deleteProducts(pid);
		return "Product Deleted Successfulyy";
	}
	
	@PutMapping("/update/{pid}")
	public Product updateProduct(@PathVariable Integer pid , @RequestBody Product product) {
		return service.updateProduct(pid, product);
		
	}



}

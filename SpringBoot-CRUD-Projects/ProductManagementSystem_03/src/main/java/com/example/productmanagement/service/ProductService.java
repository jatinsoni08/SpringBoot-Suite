package com.example.productmanagement.service;

import java.util.List;

import com.example.productmanagement.entity.Product;


public interface ProductService {
	
	Product saveAllProducts(Product product);
	
	List<Product> getAllProducts();
	
	void deleteProducts(Integer pid);
	
	Product getProductById(Integer pid );
	
	Product updateProduct(Integer pid , Product product);
	

}

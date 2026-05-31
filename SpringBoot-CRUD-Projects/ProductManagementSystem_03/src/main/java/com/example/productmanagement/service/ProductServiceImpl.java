package com.example.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public Product saveAllProducts(Product product) {
		return repository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public void deleteProducts(Integer pid) {
		repository.deleteById(pid);
	}

	@Override
	public Product getProductById(Integer pid) {
		return repository.findById(pid).orElse(null);
	}

	@Override
	public Product updateProduct(Integer pid, Product product) {

		Product dbproduct = repository.findById(pid).orElse(null);

		if (dbproduct != null) {

			dbproduct.setPname(product.getPname());
			dbproduct.setPprice(product.getPprice());
			dbproduct.setPquantity(product.getPquantity());

			return repository.save(dbproduct);
		}

		return null;
	}
}

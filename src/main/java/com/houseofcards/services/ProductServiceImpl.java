package com.houseofcards.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.houseofcards.entities.Product;

import com.houseofcards.repositories.ProductRepository;


public class ProductServiceImpl implements ProductService {
    
	private ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
	    this.productRepository = productRepository;
	}
	
	@Override
	public Iterable <Product> listAllProducts() {
	    return productRepository.findAll();
	}
	
	@Override
	public Product getProductById(Integer id) {
	    return productRepository.findById(id).get();
	    
	}
	
	@Override
	public Product saveProduct(Product product) {
	    return productRepository.save(product);
	}
	
	@Override
	public void deleteProduct(Integer id) {
	    productRepository.deleteById(id);
	}
    
}
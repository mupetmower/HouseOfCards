package com.houseofcards.services;


import org.springframework.beans.factory.annotation.Autowired;

import com.houseofcards.entities.Product;
import com.houseofcards.repositories.ProductRepository;


public class ProductService implements EntityService<Product, ProductRepository> {
    
	private ProductRepository productRepository;

	@Autowired
	public void setRepository(ProductRepository productRepository) {
	    this.productRepository = productRepository;
	}
	
	@Override
	public Iterable <Product> listAll() {
	    return productRepository.findAll();
	}
	
	@Override
	public Product getById(Integer id) {
	    return productRepository.findById(id).get();
	    
	}
	
	@Override
	public Product save(Product product) {
	    return productRepository.save(product);
	}
	
	@Override
	public void delete(Integer id) {
	    productRepository.deleteById(id);
	}
    
}

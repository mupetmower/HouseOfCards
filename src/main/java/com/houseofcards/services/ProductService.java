package com.houseofcards.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.houseofcards.entities.generated.Products;
import com.houseofcards.repositories.ProductRepository;


public class ProductService implements CrudService<Products> {
    
	private ProductRepository productRepository;

	@Autowired
	public void setRepository(ProductRepository productRepository) {
	    this.productRepository = productRepository;
	}
	
	@Override
	public Iterable <Products> listAll() {
	    return productRepository.findAll();
	}
	
	@Override
	public Products getById(Integer id) {
	    return productRepository.findById(id).get();
	    
	}
	
	@Override
	public Products save(Products product) {
	    return productRepository.save(product);
	}
	
	@Override
	public void delete(Integer id) {
	    productRepository.deleteById(id);
	}
    
}

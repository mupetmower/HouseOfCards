package com.houseofcards.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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
	
	
	public List<Products> listCountRandom(int count) {
		List<Products> p = new ArrayList<>();
				
		Long qty = productRepository.count();
	    
	    for (int i = 0; i < count; i++) {
	    	int index = (int)(Math.random() * qty);
	    	p.add(productRepository.findAll(PageRequest.of(index, 1)).getContent().get(0));
	    }
	    
	    return p;
	}
	
	public Page<Products> findRandomPageOfCount(int count) {
		
		Long qty = productRepository.count() - 1;
		int index = (int)(Math.random() * (qty-count));
		
	    return productRepository.findAll(PageRequest.of(index, count));
	    
	}
	
	public int count() {
		return (int) productRepository.count();
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

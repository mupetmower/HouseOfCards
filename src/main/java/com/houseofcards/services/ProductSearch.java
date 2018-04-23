package com.houseofcards.services;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.houseofcards.entities.ProductResult;
import com.houseofcards.entities.generated.Products;
import com.houseofcards.messages.SearchResults;
import com.houseofcards.repositories.ProductRepository;

@Service
public class ProductSearch {

	
	@Autowired
	private ProductRepository productRepo;
	
	
	
	public SearchResults searchResult(String name) {
		SearchResults s = new SearchResults();		

		List<Products> p = searchByName(name);
		
		p.forEach(product -> s.addResult(new ProductResult(product)));
		
		return s;
	}
	
	public List<Products> searchByName(String name) {
		
		Products product = new Products();
		product.setProductName(name);
		
		ExampleMatcher matcher = ExampleMatcher.matching()
				  .withIgnoreNullValues()
				  .withIgnoreCase()
				  .withStringMatcher(StringMatcher.CONTAINING);
				
		List<Products> p = productRepo.findAll(Example.of(product, matcher));
		
		//p.forEach(pp -> System.out.println(pp.getProductName()));
		return p;
	}
	
	public List<Integer> searchForIdsByName(String name) {
		
		Products product = new Products();
		product.setProductName(name);
		
		ExampleMatcher matcher = ExampleMatcher.matching()
				  .withIgnoreNullValues()
				  .withIgnoreCase()
				  .withStringMatcher(StringMatcher.CONTAINING);
				
		List<Products> p = productRepo.findAll(Example.of(product, matcher));
		
		List<Integer> ids = new ArrayList<>();

		p.forEach(pp -> {
			ids.add(pp.getPkProductId());
			System.out.println(pp.getProductName());
		});
		return ids;
	}
	
}

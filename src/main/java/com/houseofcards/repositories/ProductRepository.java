package com.houseofcards.repositories;

import org.springframework.data.repository.CrudRepository;

import com.houseofcards.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    
}

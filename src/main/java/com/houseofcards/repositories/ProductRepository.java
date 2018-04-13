package com.houseofcards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.houseofcards.entities.generated.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {
    
}

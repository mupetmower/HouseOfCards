package com.houseofcards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houseofcards.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer>{
    
}

package com.houseofcards.repositories;

import org.springframework.data.repository.CrudRepository;

import com.houseofcards.entities.generated.Sale;

public interface SaleRepository extends CrudRepository<Sale, Integer> {
    
}

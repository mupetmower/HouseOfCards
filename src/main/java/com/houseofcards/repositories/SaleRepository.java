package com.houseofcards.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.houseofcards.entities.generated.Sale;


public interface SaleRepository extends JpaRepository<Sale, Integer>, JpaSpecificationExecutor {
    
	Iterable<Sale> findByDateTimeLessThan(Date startDateTime);
	
	
}

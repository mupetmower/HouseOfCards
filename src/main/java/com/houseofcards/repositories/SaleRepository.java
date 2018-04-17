package com.houseofcards.repositories;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.houseofcards.entities.SalesByUser;
import com.houseofcards.entities.generated.Sale;


public interface SaleRepository extends JpaRepository<Sale, Integer>, JpaSpecificationExecutor {
    	
	Iterable<Sale> findByDateTimeBetween(Date start, Date end);
	
	@Query("select s from Sale s where s.user.firstName = ?1")
	Iterable<Sale> findByFirst(String s);
	
	@Query("select s from Sale s where s.user.lastName = ?1")
	Iterable<Sale> findByLast(String s);
	
	@Query("select new com.houseofcards.entities.SalesByUser(s.user, SUM(s.saleTotal)) from Sale s where s.user.firstName = ?1")
	SalesByUser findSalesByUserByFirst(String s);
	
}

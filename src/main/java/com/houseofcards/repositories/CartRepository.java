package com.houseofcards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houseofcards.entities.generated.Cartitem;

public interface CartRepository extends JpaRepository<Cartitem, Integer> {
	
	Iterable<Cartitem> findByQuantityGreaterThan(int qty);

}

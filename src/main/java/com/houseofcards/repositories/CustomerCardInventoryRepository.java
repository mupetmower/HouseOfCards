package com.houseofcards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houseofcards.entities.generated.Customercardinventory;

public interface CustomerCardInventoryRepository extends JpaRepository<Customercardinventory, Integer> {

}

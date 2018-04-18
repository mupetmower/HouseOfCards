package com.houseofcards.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.houseofcards.entities.generated.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
  
	
	
}

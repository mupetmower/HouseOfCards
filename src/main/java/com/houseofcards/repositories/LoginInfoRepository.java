package com.houseofcards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houseofcards.entities.generated.Logininfo;
import com.houseofcards.entities.generated.User;

public interface LoginInfoRepository extends JpaRepository<Logininfo, String> {
	
	public Logininfo findByUsername(String username);
	
}

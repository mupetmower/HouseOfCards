package com.houseofcards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houseofcards.entities.generated.Userrole;


public interface UserRoleRepository extends JpaRepository<Userrole, Integer> {
	
	Userrole findByPosRole(String role);

}

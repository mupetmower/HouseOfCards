package com.houseofcards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houseofcards.entities.generated.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role findByRole(String role);

}

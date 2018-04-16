package com.houseofcards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houseofcards.entities.generated.Userrole;


public interface RoleRepository extends JpaRepository<Userrole, Integer> {

}

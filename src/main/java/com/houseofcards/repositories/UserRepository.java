package com.houseofcards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houseofcards.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}

package com.houseofcards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houseofcards.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
    
}

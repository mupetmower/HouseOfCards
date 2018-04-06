package com.houseofcards.repositories;

import org.springframework.data.repository.CrudRepository;

import com.houseofcards.entities.generated.Events;


public interface EventRepository extends CrudRepository<Events, Integer> {
    
}

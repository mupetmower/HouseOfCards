package com.houseofcards.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.houseofcards.entities.generated.Events;
import com.houseofcards.repositories.EventRepository;

public class EventService implements CrudService<Events> {
    
    private EventRepository eventRepository;

    @Autowired
    public void setRepository(EventRepository eventRepository) {
	this.eventRepository = eventRepository;
    }
    
    @Override
    public Iterable<Events> listAll() {
	return eventRepository.findAll();
    }

    @Override
    public Events getById(Integer id) {
	return eventRepository.findById(id).get();
    }

    @Override
    public Events save(Events event) {
	return eventRepository.save(event);
    }

    @Override
    public void delete(Integer id) {
	eventRepository.deleteById(id);
    }
    
}

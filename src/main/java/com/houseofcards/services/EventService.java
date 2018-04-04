package com.houseofcards.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.houseofcards.entities.Entity;
import com.houseofcards.entities.Event;
import com.houseofcards.repositories.EntityRepository;
import com.houseofcards.repositories.EventRepository;

public class EventService implements EntityService<Event, EventRepository> {
    
    private EventRepository eventRepository;

    @Autowired
    public void setRepository(EventRepository eventRepository) {
	this.eventRepository = eventRepository;
    }
    
    @Override
    public Iterable<Event> listAll() {
	return eventRepository.findAll();
    }

    @Override
    public Event getById(Integer id) {
	return eventRepository.findById(id).get();
    }

    @Override
    public Event save(Event event) {
	return eventRepository.save(event);
    }

    @Override
    public void delete(Integer id) {
	eventRepository.deleteById(id);
    }
    
}

package com.houseofcards.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.houseofcards.entities.Product;
import com.houseofcards.services.EventService;
import com.houseofcards.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class EventController {
	
	
    EventService eventService;
	
    @Autowired
    public void setEventService(EventService eventService) {
    	this.eventService = eventService;
    }    
    
    
    
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("events", eventService.listAll());
        
        return "events";
    }
            
    
}

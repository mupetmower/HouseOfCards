package com.houseofcards.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.houseofcards.entities.generated.Discount;
import com.houseofcards.entities.generated.Discountedproducts;
import com.houseofcards.entities.generated.Events;
import com.houseofcards.services.EventService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

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
    
    @RequestMapping(value = "/admin/events", method = RequestMethod.POST)
    public String addEvent(Events event, @RequestParam MultipartFile eventFileChooser, 
    		@RequestParam String eventImageUri, @RequestParam String bDate, @RequestParam String eDate,
    		@RequestParam Integer discount, Model model) throws ParseException {
    	
    	if (event.getDiscounts().isEmpty()) {
    		Discount d = new Discount();
    		d.setDiscountDollarsOff(0);
    		d.setDiscountPercentage(discount);
    		
    		event.getDiscounts().add(d);
    	} else {
    		event.getDiscounts().iterator().next().setDiscountPercentage(discount);
    	}
    	    	
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date begin = df.parse(bDate);
		Date end = df.parse(bDate);
		
		event.setDateBegin(begin);
		event.setDateEnd(end);
		
		try {
    		//Get path to src/main/resources/static to save new image to
    		File srcStatic = new File("src/main/resources/static");
    		
    		//Partial path to add to end of srcStatic
    		File n = new File(eventImageUri);
    		
    		//Combine paths to create src/main/resources/static + /images/product/...etc
    		String newPath = srcStatic.getAbsolutePath() + n.getPath();
    		
    		//System.out.println("newPath: " + newPath);
    		
    		//Create a new File from newPath
    		File newImg = new File(newPath);
    		
    		//Create a copy of file from user(couldnt use transferTo more than once otherwise)
    		MultipartFile imgCopy = eventFileChooser;
    		
    		//Transfer file from user into path of this new File
    		imgCopy.transferTo(newImg);
    		
    		
    		
    		
    		//Need to also save new img to target/static dir because this is where maven puts all
    		//resources when built/installed and there is no build after image is saved.
    		File targetStatic = new ClassPathResource("static").getFile();
    		
    		String newPath2 = targetStatic.getAbsolutePath() + eventImageUri;
    		
    		File newImg2 = new File(newPath2);
    		
    		//Copy our moved file to a new file in target dir if it doesnt exist
    		if (!newImg2.exists() && !newImg2.isFile())
    			Files.copy(Paths.get(newImg.getAbsolutePath()), Paths.get(newImg2.getAbsolutePath()));
    		
    		
    		//Lastly, set product's thumbnail path to given path. Last because we dont want this to 
    		//Change unless files are saved
    		event.setEventImageUri(eventImageUri);
    		
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
    	eventService.save(event);
    	
        //model.addAttribute("events", eventService.listAll());
        
        return "redirect:/events";
    }
    
    
    @RequestMapping(value = "/admin/events/remove/{eventId}")
    public String remove(Model model, @PathVariable Integer eventId){
        eventService.delete(eventId);
        
        return "redirect:/events";
    }
    
    @RequestMapping(value = "/admin/events/new")
    public String newEvent(Model model){
        model.addAttribute("event", new Events());
        model.addAttribute("discount", 0);
        return "eventform";
    }
    
    @RequestMapping(value = "/admin/events/edit/{eventId}")
    public String editEvent(@PathVariable Integer eventId, Model model){
    	Events e = eventService.getById(eventId);
        model.addAttribute("event", e);
        if (e.getDiscounts().isEmpty()) {
        	model.addAttribute("discount", 0);
        } else {
        	model.addAttribute("discount", e.getDiscounts().iterator().next().getDiscountPercentage());
        }
        
        return "eventform";
    }
            
    
}

package com.houseofcards.controllers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.houseofcards.entities.generated.Cartitem;
import com.houseofcards.entities.generated.User;
import com.houseofcards.services.UserService;

@ControllerAdvice
public class CustomControllerAdvice {
	
	@Autowired
	private UserService userService;
	
	
	@ModelAttribute
    public void addUserToModel(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        User user = userService.findByUsername(username);
        
        if (user != null)
        	model.addAttribute("user", user);
        else
        	model.addAttribute("user", new User());
        
        
    }
	
	
	@ModelAttribute
    public void addCartToModel(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        User user = userService.findByUsername(username);
        
        if (user != null) {
        	Set<Cartitem> cartItems = user.getCartitems()
        								.stream()
        								.filter(c -> c.isPurchased() == false)
        								.collect(Collectors.toSet());
        	
        	        	
        	
        	if (cartItems != null && !cartItems.isEmpty() && cartItems.size() > 0) {
        		
        		model.addAttribute("cartitems", cartItems);
        		
        		int cartSize = cartItems.stream()
        				.mapToInt(c -> c.getQuantity())
        				.sum();
        		
        		
        		
        		model.addAttribute("cartsize", cartSize);
        		
        		System.out.println(cartSize);
        	} else {
        		
        		model.addAttribute("cartitems", new Cartitem());
    			model.addAttribute("cartsize", 0);
        	}
        	
        } else {
        	model.addAttribute("cartitems", new Cartitem());
    		model.addAttribute("cartsize", 0);
        }
    }

}

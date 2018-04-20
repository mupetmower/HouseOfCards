package com.houseofcards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.houseofcards.entities.generated.User;
import com.houseofcards.services.UserService;

@ControllerAdvice
public class UserControllerAdvice {
	
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

}

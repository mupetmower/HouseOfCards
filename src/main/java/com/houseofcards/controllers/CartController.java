package com.houseofcards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.houseofcards.messages.CartMessage;
import com.houseofcards.services.UserService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/{userId}")
    public String showCart(@PathVariable Integer userId, Model model){
    	
    	model.addAttribute("cartMessage", new CartMessage());
		
    	return "viewcart";
    }
	

}

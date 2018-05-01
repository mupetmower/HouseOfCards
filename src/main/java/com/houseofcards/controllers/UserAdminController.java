package com.houseofcards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.houseofcards.repositories.UserRepository;

@Controller
@RequestMapping("/admin/users")
public class UserAdminController {
	
	@Autowired
	private UserRepository userRepo;
	
	
	@RequestMapping("/all")
	public String listAllUsers(Model model) {
		
		model.addAttribute("allusers", userRepo.findAll());
		
		
		return "allusers";
	}
	
	@RequestMapping("/delete/{userId}")
	public String removeUser(@PathVariable Integer userId, Model model) {
		
		
		userRepo.deleteById(userId);
		
		model.addAttribute("allusers", userRepo.findAll());
		
		
		return "allusers";
	}
	

}

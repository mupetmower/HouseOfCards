package com.houseofcards.controllers;

import java.util.Date;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.houseofcards.repositories.SaleRepository;
import com.houseofcards.repositories.UserRepository;

@Controller
public class TestingController {
		
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SaleRepository saleRepo;
	
		
	@RequestMapping("/testing")
	public String mockup(Model model) {
				
		model.addAttribute("users", userRepo.findAll());
		
		
		model.addAttribute("sales", saleRepo.findByDateTimeLessThan(new Date(2018,1,1)));
		//System.out.println(saleRepo.findByDateTimeBetween(new Date(2017, 3, 1), new Date(2018, 5, 1)).iterator().next().getSaleTotal());
		return "testpage";		
	}
		
	
	@RequestMapping("/allpagestemp")
	public String temp() {
		return "allpagestemplate";		
	}
	
}

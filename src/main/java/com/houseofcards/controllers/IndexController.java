package com.houseofcards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.houseofcards.services.ProductService;

@Controller
public class IndexController {
	
	@Autowired
	public ProductService productService;
    
    @RequestMapping("/")
    public String showIndex(Model model) {
    	model.addAttribute("products", productService.listAll());
    	return "IndexMockup";
    }
    
}

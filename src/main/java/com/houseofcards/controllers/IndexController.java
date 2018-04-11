package com.houseofcards.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.houseofcards.entities.generated.Products;
import com.houseofcards.entities.generated.Topproducts;
import com.houseofcards.repositories.EntityRepository;
import com.houseofcards.repositories.TopProductsRepository;
import com.houseofcards.services.EntityService;
import com.houseofcards.services.ProductService;

@Controller
public class IndexController {
	
	@Autowired
	public ProductService productService;
	
	@Autowired
	private TopProductsRepository topProductsRepo;
	
    
    @RequestMapping("/")
    public String showIndex(Model model) {
    	model.addAttribute("products", productService.listAll());
    	model.addAttribute("topproducts", topProductsRepo.findAll());    	   	
    	
    	return "IndexMockup";
    }
    
}

package com.houseofcards.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.houseofcards.entities.generated.Products;
import com.houseofcards.repositories.ProductRepository;
import com.houseofcards.repositories.TopProductsRepository;
import com.houseofcards.services.ProductService;

@Controller
public class IndexController {
	
	@Value("${randProductsCount:unknown}")
	private int randProductsCount;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	public ProductService productService;
	
	@Autowired
	private TopProductsRepository topProductsRepo;
	
    
    @RequestMapping("/")
    public String showIndex(Model model) {
    	List<Products> products = productService.listCountRandom(randProductsCount);
    	
    	model.addAttribute("products", products);
    	model.addAttribute("topproducts", topProductsRepo.findAll());    	   	
    	
    	return "IndexMockup";
    }
    
}

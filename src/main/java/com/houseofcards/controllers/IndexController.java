package com.houseofcards.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.houseofcards.entities.generated.Products;
import com.houseofcards.repositories.ProductRepository;
import com.houseofcards.repositories.TopProductsRepository;
import com.houseofcards.repositories.UserRepository;
import com.houseofcards.services.ProductService;

@Controller
public class IndexController {
	
	@Value("${randProductsCount:int}")
	private int randProductsCount;
	
	
	@Autowired
	public ProductService productService;
	
	@Autowired
	private TopProductsRepository topProductsRepo;
	
	
    
    @RequestMapping("/")
    public String showIndex(Model model) {
    	//Get all products and fill List with random selections from products for home page
    	List<Products> products = new ArrayList<>();    	
    	List<Products> p = (List<Products>) productService.listAll();
    	    	
    	for (int i = 0; i < randProductsCount; i++) {
    		int index = (int)(Math.random() * p.size());
    		products.add(p.get(index));
    		p.remove(index);    		
    	}
    	
    	
    	model.addAttribute("products", products);
    	model.addAttribute("topproducts", topProductsRepo.findAll());

    	System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    	
    	if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null
    			&& !SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) 
    	{
    		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        	
        	user.getAuthorities().forEach(a -> System.out.println(a.getAuthority()));
        	
        	//session.addAttribute("user", user);
        	model.addAttribute("userauth", user.getAuthorities());
    	}
    	
    	
    	return "IndexMockup";
    }
    
}

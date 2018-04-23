package com.houseofcards.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.houseofcards.entities.generated.Customercardinventory;
import com.houseofcards.entities.generated.Premiumcustomerdetails;
import com.houseofcards.entities.generated.Products;
import com.houseofcards.entities.generated.User;
import com.houseofcards.messages.SearchRequest;
import com.houseofcards.messages.SearchResults;
import com.houseofcards.repositories.CustomerCardInventoryRepository;
import com.houseofcards.repositories.ProductRepository;
import com.houseofcards.services.ProductSearch;
import com.houseofcards.services.UserService;


@Controller
@RequestMapping("/premium/cards")
public class UserCardsController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerCardInventoryRepository userCardRepo;
	
	@Autowired
	private ProductSearch productSearch;
	
	@Autowired
	private ProductRepository productRepo;
	
	
	@RequestMapping("")
	public String showUserCards(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        User user = userService.findByUsername(username);
        
        if (!user.getPremiumcustomerdetailses().isEmpty()) {
        	Premiumcustomerdetails premiumDetails = user.getPremiumcustomerdetailses().iterator().next();
        	model.addAttribute("cards", user.getPremiumcustomerdetailses().iterator().next().getCustomercardinventories());
        	model.addAttribute("premiumcustomerdetails", premiumDetails);
        }
		return "usercards";
	}
	
	
	@RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
    	//model.addAttribute("product", productService.getById(id));
    	//model.addAttribute("productImages", productService.getById(id).getProductimages());
    	return "usercardeditform";
    }
    
    
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
    	//productService.delete(id);
    	return "redirect:/usercards";
    }
    
    @RequestMapping("/new/{premiumid}")
    public String newCard(@PathVariable Integer premiumid, Model model, String searchName){
    	Customercardinventory userCard = new Customercardinventory();
    	
    	model.addAttribute("newCards", userCard);
    	
    	return "premiumaddcardform";
    }
    
    
    @MessageMapping("/premiumcards/search")
    @SendTo("/topic/premiumcards/search/results")
	public @ResponseBody SearchResults searchProducts(@RequestBody SearchRequest request) {
		System.out.println("Searching");
    	
    	//List<Integer> ids = productSearch.searchForIdsByName(request.getProductName());
    	
    	//p.forEach(ps -> System.out.println(ps.getProductName()));
    	
    	//SearchResults s = new SearchResults();
    	
    	//ids.forEach(id -> s.addResult(productRepo.findById(id).get()));
    	
    	
    	//p.forEach(pp -> s.addResult(pp));
    	
    	//s.setResults(p);
    	
    	return productSearch.searchResult(request.getProductName());
	}
    
	
	
	
}

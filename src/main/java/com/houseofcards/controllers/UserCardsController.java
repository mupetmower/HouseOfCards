package com.houseofcards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.houseofcards.entities.generated.User;
import com.houseofcards.services.UserService;

@Controller
@RequestMapping("/premium/cards")
public class UserCardsController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping("")
	public String showUserCards(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        User user = userService.findByUsername(username);
        
        if (!user.getPremiumcustomerdetailses().isEmpty())
        	model.addAttribute("cards", user.getPremiumcustomerdetailses().iterator().next().getCustomercardinventories());
		
		return "usercards";
	}
	
	
	@RequestMapping("premium/cards/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
    	//model.addAttribute("product", productService.getById(id));
    	//model.addAttribute("productImages", productService.getById(id).getProductimages());
    	return "usercardeditform";
    }
    
    
    @RequestMapping("premium/cards/delete/{id}")
    public String delete(@PathVariable Integer id){
    	//productService.delete(id);
    	return "redirect:/usercards";
    }
	
	
	
}

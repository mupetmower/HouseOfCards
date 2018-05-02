package com.houseofcards.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.houseofcards.entities.generated.Cartitem;
import com.houseofcards.entities.generated.Products;
import com.houseofcards.entities.generated.User;
import com.houseofcards.messages.CartMessage;
import com.houseofcards.repositories.CartRepository;
import com.houseofcards.repositories.ProductRepository;
import com.houseofcards.repositories.UserRepository;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CartRepository cartRepo;
	
	
	@RequestMapping("/{userId}")
    public String showCart(@PathVariable Integer userId, Model model){
    	
    	//model.addAttribute("cartMessage", new CartMessageItem());
		model.addAttribute("user-object", userRepo.findById(userId));
    	return "viewcart";
    }
	
	
	@RequestMapping("/submit/{user}")
    public String submit(@PathVariable Integer user, Model model) {
    	
		//Integer itemId, Integer userId, Integer productId, Integer quantity
		//CartMessageItem cartMessage = new CartMessageItem(itemId, productId, userId, quantity);
    	
		
		
		//model.addAttribute("cartMessage", cartMessage);
		
    	return "paymentdetails";
    }
	
	
	@RequestMapping("/remove/{userId}/{cartItemId}")
	public String removeCartItem(Model model, @PathVariable Integer userId, @PathVariable Integer cartItemId) {
		Cartitem c = cartRepo.findById(cartItemId).get();
		cartRepo.delete(c);
		
		return "redirect:/cart/" + userId;
	}
	
	
	@RequestMapping("/checkoutrequest/{userId}")
	public String checkoutRequest(String request, @PathVariable Integer userId) {
				
		System.out.println(request);
		CartMessage items = null;
		try {
			items = new ObjectMapper().readValue(request, CartMessage.class);
						
			items.getCartMessageItems().forEach(cmi -> System.out.println("ID: " + cmi.getProductId() + 
					"QTY: " + cmi.getQuantity()));
			
			
			items.getCartMessageItems().forEach(cmi -> {
				Cartitem c = cartRepo.findById(cmi.getItemId()).get();
				c.setQuantity(cmi.getQuantity());
				cartRepo.save(c);
			});
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/paymentdetails";
	}
	
	
	@RequestMapping("/addtocart/{userId}/{productId}")
	public String addToCart(Model model, @PathVariable Integer userId, @PathVariable Integer productId) {

		Products p = productRepo.findById(productId).get();
		User u = userRepo.findById(userId).get();
		
		Cartitem cartItem = new Cartitem();
		cartItem.setPurchased(false);
		cartItem.setProducts(p);
		cartItem.getProducts().setPrice(p.getPrice());
		cartItem.setUser(u);
		cartItem.setQuantity(1);
		cartRepo.save(cartItem);
		
		p.getCartitems().add(cartItem);
		
		u.getCartitems().add(cartItem);
		
		productRepo.save(p);
		userRepo.save(u);
		
		
		return "redirect:/cart/" + userId;
	}

}

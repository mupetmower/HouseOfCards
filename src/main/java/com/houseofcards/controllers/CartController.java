package com.houseofcards.controllers;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.houseofcards.entities.generated.Cartitem;
import com.houseofcards.messages.CartMessage;
import com.houseofcards.messages.CartMessageItem;
import com.houseofcards.repositories.CartRepository;
import com.houseofcards.services.UserService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartRepository cartRepo;
	
	
	@RequestMapping("/{userId}")
    public String showCart(@PathVariable Integer userId, Model model){
    	
    	//model.addAttribute("cartMessage", new CartMessageItem());
		
    	return "viewcart";
    }
	
	
	@RequestMapping("/submit/{user}")
    public String submit(@PathVariable Integer user, Model model) {
    	
		//Integer itemId, Integer userId, Integer productId, Integer quantity
		//CartMessageItem cartMessage = new CartMessageItem(itemId, productId, userId, quantity);
    	
		
		
		//model.addAttribute("cartMessage", cartMessage);
		
    	return "paymentdetails";
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
		
		return "paymentdetails";
	}
	
	
	@RequestMapping("/add/{userId}/{productId}")
	public String addToCart(Model model, @PathVariable Integer userId, @PathVariable Integer productId) {
		
		
		
		return "confirmpurchase";
	}

}

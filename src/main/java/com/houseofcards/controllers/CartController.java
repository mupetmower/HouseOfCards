package com.houseofcards.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.houseofcards.entities.generated.Cartitem;
import com.houseofcards.entities.generated.Paymentdetails;
import com.houseofcards.entities.generated.Products;
import com.houseofcards.entities.generated.User;
import com.houseofcards.messages.CartMessage;
import com.houseofcards.repositories.CartRepository;
import com.houseofcards.repositories.PaymentdetailsRepository;
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
	
	@Autowired
	private PaymentdetailsRepository paymentDetailsRepo;
	
	
	@RequestMapping("/{userId}")
    public String showCart(@PathVariable Integer userId, Model model){
    	
    	//model.addAttribute("cartMessage", new CartMessageItem());
		model.addAttribute("user-object", userRepo.findById(userId));
    	return "viewcart";
    }
	
	
	@RequestMapping("/confirmpurchase/{userId}")
    public String submit(@PathVariable Integer userId, Model model) {
		User user = userRepo.findById(userId).get();
		
		user.getCartitems().forEach(ci -> {
			ci.setPurchased(true);
			cartRepo.save(ci);
		});
		
		
		model.addAttribute("purchasemessage", "Thank You for Your Purchase!");
		
		
    	return "purchasesuccess";
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
		
		return "redirect:/cart/paymentdetails/" + userId;
	}
	
	
	@RequestMapping("/paymentdetails/{userId}")
	public String paymentDetails(Model model, @PathVariable Integer userId) {
		
		User user = userRepo.findById(userId).get();
		
		
		//Add payment details or new details obj
		if (user.getPaymentdetailses() == null || user.getPaymentdetailses().size() < 1) {
			Paymentdetails payment = new Paymentdetails();
			payment.setUser(user);
			model.addAttribute("paymentdetails", payment);
		} else {
			model.addAttribute("paymentdetails", user.getPaymentdetailses().iterator().next());
		}
		
		//Add all cart pricing
		List<Cartitem> items = user.getCartitems().stream().filter(ci -> !ci.isPurchased()).collect(Collectors.toList());
		
		double subtotal = items.stream().mapToDouble(ci -> ((double)ci.getQuantity() * ci.getProducts().getPrice().doubleValue())).sum();
		double tax = subtotal * 0.07;
		double total = subtotal + tax;
		
		model.addAttribute("subtotal", subtotal);
		model.addAttribute("tax", tax);
		model.addAttribute("total", total);
		
		return "paymentdetails";
	}
	
	@RequestMapping("/review/{userId}")
	public String reviewPurchase(Paymentdetails paymentdetails, String cardExp, String radCardType, Model model,
			@PathVariable Integer userId) throws ParseException {
		
		//System.out.println(rad);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(cardExp);
		paymentdetails.setCardExpiration(date);
		paymentdetails.setCardType(radCardType);
		
		
		
		paymentDetailsRepo.save(paymentdetails);
		
		User user = userRepo.findById(userId).get();
		
		List<Cartitem> items = user.getCartitems().stream().filter(ci -> !ci.isPurchased()).collect(Collectors.toList());
		
		model.addAttribute("cartItems", items);
		
		double subtotal = items.stream().mapToDouble(ci -> ((double)ci.getQuantity() * ci.getProducts().getPrice().doubleValue())).sum();
		double tax = subtotal * 0.07;
		double total = subtotal + tax;
		
		model.addAttribute("subtotal", subtotal);
		model.addAttribute("tax", tax);
		model.addAttribute("total", total);

		return "reviewpurchase";
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

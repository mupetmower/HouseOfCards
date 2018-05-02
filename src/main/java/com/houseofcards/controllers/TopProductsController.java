package com.houseofcards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.houseofcards.entities.generated.Topproducts;
import com.houseofcards.repositories.TopProductsRepository;


@Controller
@RequestMapping("/admin/topproducts")
public class TopProductsController {
	
	@Autowired
	private TopProductsRepository topProductRepo;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listAllTopProducts(Model model) {
		model.addAttribute("topproducts", topProductRepo.findAll());
		
		return "topproducts";
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String listAllTopProducts(Topproducts topProduct, Model model) {
		topProductRepo.save(topProduct);
		
		model.addAttribute("topproducts", topProductRepo.findAll());
		
		return "topproducts";
	}
	
	
	@RequestMapping("/new")
	public String addTopProduct(Model model, @PathVariable Integer topProductId) {
		model.addAttribute("topproduct", new Topproducts());
		
		return "topproductform";
	}
	
	
	
	@RequestMapping("/remove/{topProductId}")
	public String removeTopProduct(Model model, @PathVariable Integer topProductId) {
		topProductRepo.delete(topProductRepo.findById(topProductId).get());
		
		return "topproducts";
	}
	
}

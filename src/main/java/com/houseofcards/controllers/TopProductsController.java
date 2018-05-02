package com.houseofcards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.houseofcards.entities.generated.Products;
import com.houseofcards.entities.generated.Topproducts;
import com.houseofcards.repositories.ProductRepository;
import com.houseofcards.repositories.TopProductsRepository;


@Controller
@RequestMapping("/admin/topproducts")
public class TopProductsController {
	
	@Autowired
	private TopProductsRepository topProductRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
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
	
	
	@RequestMapping(value = "/new")
	public String sendToAddForm(Model model) {
		model.addAttribute("topproduct", new Topproducts());
		
		return "topproductform";
	}
	
	@RequestMapping(value = "/new/{productId}")
	public String addTopProduct(Model model, @PathVariable Integer productId) {		
		Products p = productRepo.findById(productId).get();
		
		Topproducts t = new Topproducts();
		t.setProducts(p);
		
		topProductRepo.save(t);
		
		return "redirect:/admin/topproducts";
	}
	
	
	
	@RequestMapping("/delete/{topProductId}")
	public String removeTopProduct(Model model, @PathVariable Integer topProductId) {
		topProductRepo.deleteById(topProductId);
		
		return "redirect:/admin/topproducts";
	}
	
}

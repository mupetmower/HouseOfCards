package com.houseofcards.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.houseofcards.entities.Product;
import com.houseofcards.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ProductController {
	
	
    ProductService productService;
	
    @Autowired
    public void setProductService(ProductService productService) {
	this.productService = productService;
    }
    
    @RequestMapping("product/new")
    public String newProduct(Model model){
	model.addAttribute("product", new Product());
	return "productform";
    }
    
    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product){
	productService.save(product);
	return "redirect:/product/" + product.getProductId();
    }
    
    @RequestMapping("product/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "productshow";
    }
    
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("products", productService.listAll());
        return "products";
    }
    
    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
	model.addAttribute("product", productService.getById(id));
	return "productform";
    }
    
    
    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable Integer id){
	productService.delete(id);
	return "redirect:/products";
    }
    
    
    
}

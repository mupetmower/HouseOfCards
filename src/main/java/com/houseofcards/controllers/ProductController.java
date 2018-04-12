package com.houseofcards.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.houseofcards.entities.generated.Products;
import com.houseofcards.repositories.ProductImageRepository;
import com.houseofcards.services.ProductService;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

@Controller
public class ProductController {
	
	
    ProductService productService;
    ProductImageRepository productImageRepository;
    
    
	
    @Autowired
    public void setProductService(ProductService productService) {
    	this.productService = productService;
    }
    
    @Autowired
    public void setProductImageRepository(ProductImageRepository productImageRepository) {
    	this.productImageRepository = productImageRepository;
    }
    
    @RequestMapping("product/new")
    public String newProduct(Model model){
    	model.addAttribute("product", new Products());
    	return "productform";
    }
    
    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Products product, MultipartFile thumbnailFileChooser, String thumbnailUri){
    	
    	
    	try {
    		File staticRes = new ClassPathResource("static").getFile();
    		
    		String newPath2 = staticRes.getAbsolutePath() + thumbnailUri;
    		
    		
    		String newPath = thumbnailUri;
    		
    		product.setThumbnailUri(thumbnailUri);
    		
    		File newImg = new File(newPath2);
    		
    		
    		thumbnailFileChooser.transferTo(newImg);
    		
    					
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
    	

    	
    	productService.save(product);
    	
    	
    	
    	
    	return "redirect:/product/" + product.getPkProductId();
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
    	model.addAttribute("productImages", productService.getById(id).getProductimages());
    	return "productform";
    }
    
    
    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable Integer id){
    	productService.delete(id);
    	return "redirect:/products";
    }
    
    
    
}

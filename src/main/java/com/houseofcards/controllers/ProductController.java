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
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    
    @RequestMapping("/admin/product/new")
    public String newProduct(Model model){
    	model.addAttribute("product", new Products());
    	return "productform";
    }
    
    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Products product, MultipartFile thumbnailFileChooser, String thumbnailUri){
    	
    	
    	try {
    		//Get path to src/main/resources/static to save new image to
    		File srcStatic = new File("src/main/resources/static");
    		
    		//Partial path to add to end of srcStatic
    		File n = new File(thumbnailUri);
    		
    		//Combine paths to create src/main/resources/static + /images/product/...etc
    		String newPath = srcStatic.getAbsolutePath() + n.getPath();
    		
    		//System.out.println("newPath: " + newPath);
    		
    		//Create a new File from newPath
    		File newImg = new File(newPath);
    		
    		//Create a copy of file from user(couldnt use transferTo more than once otherwise)
    		MultipartFile imgCopy = thumbnailFileChooser;
    		
    		//Transfer file from user into path of this new File
    		imgCopy.transferTo(newImg);
    		
    		
    		
    		
    		//Need to also save new img to target/static dir because this is where maven puts all
    		//resources when built/installed and there is no build after image is saved.
    		File targetStatic = new ClassPathResource("static").getFile();
    		
    		String newPath2 = targetStatic.getAbsolutePath() + thumbnailUri;
    		
    		File newImg2 = new File(newPath2);
    		
    		//Copy our moved file to a new file in target dir if it doesnt exist
    		if (!newImg2.exists() && !newImg2.isFile())
    			Files.copy(Paths.get(newImg.getAbsolutePath()), Paths.get(newImg2.getAbsolutePath()));
    		
    		
    		//Lastly, set product's thumbnail path to given path. Last because we dont want this to 
    		//Change unless files are saved
    		product.setThumbnailUri(thumbnailUri);
    		
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
    
    @RequestMapping("admin/product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
    	model.addAttribute("product", productService.getById(id));
    	model.addAttribute("productImages", productService.getById(id).getProductimages());
    	return "productform";
    }
    
    
    @RequestMapping("admin/product/delete/{id}")
    public String delete(@PathVariable Integer id){
    	productService.delete(id);
    	return "redirect:/products";
    }
    
    
    
}

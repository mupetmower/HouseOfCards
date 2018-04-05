package com.houseofcards.webplatform;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.houseofcards.entities.Product;
import com.houseofcards.services.ProductService;


@SpringBootApplication
@ComponentScan(basePackages = {"com.houseofcards.*"})
public class WebplatformApplication {
    
    public static void main(String[] args) {
    	SpringApplication.run(WebplatformApplication.class, args);
	
		
	
    }
    
    
    
}

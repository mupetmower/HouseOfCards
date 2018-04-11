package com.houseofcards.webplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.houseofcards.*"})
public class WebplatformApplication {
    
    public static void main(String[] args) {
    	SpringApplication.run(WebplatformApplication.class, args);
	
		
	
    }
    
    
    
}

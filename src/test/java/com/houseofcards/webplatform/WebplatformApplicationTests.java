package com.houseofcards.webplatform;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.houseofcards.entities.Entity;
import com.houseofcards.entities.Event;
import com.houseofcards.entities.Sale;
import com.houseofcards.repositories.EntityRepository;
import com.houseofcards.repositories.EventRepository;
import com.houseofcards.services.EntityService;
import com.houseofcards.services.EventService;
import com.houseofcards.services.ProductService;
import com.houseofcards.services.SaleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebplatformApplicationTests {
    
    public ProductService productService;
    public EventService eventService;
    public SaleService saleService;
    
    @Autowired
    public void setProductService(ProductService productService) {
	this.productService = productService;
    }
    
    @Autowired
    public void setEventService(EventService eventService) {
	this.eventService = eventService;
    }
    
    @Autowired
    public void setSaleService(SaleService saleService) {
	this.saleService = saleService;
    }
    
    public List<EntityService<Entity, EntityRepository<Entity>>> entityServices;

    @Test
    public void contextLoads() {
		
	productService.listAll().forEach(e -> System.out.println(e.getProductName()));
	eventService.listAll().forEach(e -> System.out.println(e.getEventName()));
	saleService.listAll().forEach(e -> System.out.println(e.getSaleTotal()));
	
	
	entityServices.add((EntityService)eventService);
	entityServices.add((EntityService)saleService);
	
	entityServices.forEach(s -> s.listAll()
		.forEach(e -> e.print()));
	
    }

}

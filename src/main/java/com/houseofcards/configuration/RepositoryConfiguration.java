package com.houseofcards.configuration;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.houseofcards.services.EventService;
import com.houseofcards.services.ProductService;
import com.houseofcards.services.SaleService;


@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.houseofcards.entities"})
@EnableJpaRepositories(basePackages = {"com.houseofcards.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
    
    @Bean
    ProductService productService(){
        return new ProductService();
    }

    @Bean
    EventService eventService(){
        return new EventService();
    }

    @Bean
    SaleService saleService(){
        return new SaleService();
    }
    
    

}

package com.houseofcards.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class MySqlConfiguration {
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    
	    driverManagerDataSource.setUrl("jdbc:mysql://25.7.50.219:3306/houseofcards?autoReconnect=true&useSSL=false&username=afrye&password=AlexFrye!");
	    driverManagerDataSource.setUsername("afrye");
	    driverManagerDataSource.setPassword("AlexFrye!");
	    return driverManagerDataSource;
	}
}

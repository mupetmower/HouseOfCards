package com.houseofcards.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.houseofcards.services.UserDetailsServiceImpl;

@Configuration
public class WebConfiguration {
    
//    @Bean
//    ServletRegistrationBean<WebServlet> h2servletRegistration(){
//        ServletRegistrationBean<WebServlet> registrationBean = new ServletRegistrationBean<WebServlet>( new WebServlet());
//        registrationBean.addUrlMappings("/console/*");
//        return registrationBean;
//    }
    
	
//	@Override
//	public void configure(AuthenticationManagerBuilder builder) throws Exception {
//		builder.userDetailsService(new UserDetailsServiceImpl());
//	}
//	
//	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
	
	
}

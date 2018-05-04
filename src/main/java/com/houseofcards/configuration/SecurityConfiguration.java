package com.houseofcards.configuration;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.houseofcards.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	//Might need datasource later
	@Autowired
	DataSource dataSource;
	
	
	//Configure security for different endpoints
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
        
        httpSecurity
        	.authorizeRequests()
        		.antMatchers("/admin/**")
        		.hasRole("ADMIN")
        		
        	.and()
        	
        	.authorizeRequests()
        		.antMatchers("/premium/**")
        		.hasAuthority("Premium")
        		
    		.and()
        	
        	.authorizeRequests()
        		.antMatchers("/cart/**")
        		.authenticated()	
        	
        	.and()
        	
        	.formLogin()
        		.loginPage("/login")
        		.defaultSuccessUrl("/");
        
        
        httpSecurity
        	.logout()
        	.logoutSuccessUrl("/");
        
        		
        
    }
	
	
	//No password encryption
	@SuppressWarnings("deprecation")
	@Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance ();
    }
	
	
	
	//AuthenticationManager supplied from super
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	
	//May use BCrypt later if time allows.
//	@Bean
//	public BCryptPasswordEncoder bCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	
	
	
//	
//	@Override
//	public void configure(AuthenticationManagerBuilder builder) throws Exception {
//		builder.userDetailsService(new UserDetailsServiceImpl());
//		//builder.authenticationProvider(authenticationProvider());
//		
//		//builder.jdbcAuthentication().dataSource(dataSource);
//	}
	
//	@Override
//	public void configure(WebSecurity webSecurity) throws Exception {
//		webSecurity
//			.ignoring()
//				.antMatchers("/**");
//	}
	
	
//	@Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user").password("user").roles("ADMIN").build());
//        
//        return manager;
//    }
	

//	
//	@Autowired
//	private UserDetailsServiceImpl userDetailsService;
	 
	 
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//	    DaoAuthenticationProvider authProvider
//	      = new DaoAuthenticationProvider();
//	    authProvider.setUserDetailsService(userDetailsService);
//	    return authProvider;
//	}
	

	

	
	
//	@Bean
//	@Override
//	protected	 
//    UserDetailsService userDetailsService() {
//    	try {
//			return super.userDetailsServiceBean();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	return null;
////    	UserDetails user =
////    	         User.withDefaultPasswordEncoder()
////    	            .username("user")
////    	            .password("password")
////    	            .roles("USER")
////    	            .build();
////
////    	    return new InMemoryUserDetailsManager(user);
//    }
	
//	@Bean
//	public static NoOpPasswordEncoder passwordEncoder() {
//	 return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}
	
	
	


	

}

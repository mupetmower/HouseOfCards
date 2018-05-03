package com.houseofcards.services;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.houseofcards.entities.generated.User;
import com.houseofcards.repositories.LoginInfoRepository;
import com.houseofcards.repositories.ProductRepository;
import com.houseofcards.repositories.RoleRepository;
import com.houseofcards.repositories.UserRepository;

public class UserService {

	private UserRepository userRepository;
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
	    this.userRepository = userRepository;
	}
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	public User findById(Integer id) {
		return userRepository.findById(id).get();
	}
	
	public User findByUsername(String username) {
		return userRepository.findByLogininfo_Username(username);
	}
	
	
    public void save(User user) {    	
        
        userRepository.save(user);
    }
	
}

package com.houseofcards.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.houseofcards.entities.generated.Logininfo;
import com.houseofcards.entities.generated.User;
import com.houseofcards.entities.generated.Userrole;
import com.houseofcards.repositories.LoginInfoRepository;
import com.houseofcards.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;


public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Autowired
    private LoginInfoRepository loginRepo;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       	User user = userService.findByUsername(username);
        System.out.println(user.getFirstName());
        System.out.println(user.getLogininfo().getPassword());
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserrole().getRoleType()));        
        

        return new org.springframework.security.core.userdetails.User(user.getLogininfo().getUsername(), user.getLogininfo().getPassword(), grantedAuthorities);
    }
}

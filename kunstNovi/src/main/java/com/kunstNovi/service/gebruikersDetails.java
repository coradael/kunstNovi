package com.kunstNovi.service;

import com.kunstNovi.model.user;
import com.kunstNovi.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// importante
@Service
public class gebruikersDetails implements UserDetailsService {

    @Autowired
    userRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        
        user user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> 
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
        );

        return userPrincipal.create(user);
    }

    
    @Transactional
    public UserDetails loadUserById(Long id) {
        user user = userRepository.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return userPrincipal.create(user);
    }
}
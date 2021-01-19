package com.kunstNovi.controller;


import com.kunstNovi.model.user;
import com.kunstNovi.payload.*;
import com.kunstNovi.repository.userRepository;
import com.kunstNovi.service.userPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class userController {

    @Autowired
    private userRepository userRepository;



    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public userSummary getCurrentUser( userPrincipal currentUser) {
        userSummary userSummary = new userSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }



    @GetMapping("/users/{username}")
    public userProfile getUserProfile(@PathVariable(value = "username") String username) {
        user user = userRepository.findByUsername(username)
               
                		.orElseThrow(() -> new IllegalStateException("username niet gevonden"));
                		
        userProfile userProfile = new userProfile(user.getId(), user.getUsername(), user.getName()
        		
       		);

       return userProfile;
    }

}
package com.kunstNovi.controller;

import com.kunstNovi.service.AppException;
import com.kunstNovi.model.role;
import com.kunstNovi.model.roleName;
import com.kunstNovi.model.user;
import com.kunstNovi.model.apiResponse;
import com.kunstNovi.model.JwtVerificatie;
import com.kunstNovi.payload.loginRequest;
import com.kunstNovi.payload.signUpRequest;
import com.kunstNovi.repository.RoleRepository;
import com.kunstNovi.repository.userRepository;
import com.kunstNovi.service.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/api/novi")
public class webController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    userRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody loginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtVerificatie(jwt));
		
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody signUpRequest signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<Object>(new apiResponse<Object>(false, "User naam is al gemaakt!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<Object>(new apiResponse<Object>(false, "Email Address is al gebruikt!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        user user = new user(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        role userRole = roleRepository.findByName(roleName.ROLE_USER)
               .orElseThrow(() -> new AppException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));

        user result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

       return ResponseEntity.created(location).body(new apiResponse<Object>(true, "User is al geregistreerd"));
    }
}

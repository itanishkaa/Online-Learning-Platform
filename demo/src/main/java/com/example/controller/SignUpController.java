package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.UserDetails;
import com.example.service.CreatedUserService;
import com.example.service.ValidateLoginService;

@RestController
@CrossOrigin
@RequestMapping("/demo")
public class SignUpController {
    @Autowired
    private CreatedUserService createdUserService;

    @Autowired
    private ValidateLoginService validateLoginService;

    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }

    @PostMapping("/signup") 
    public ResponseEntity<String> saveUser(@RequestBody UserDetails user) {
        UserDetails savedUser = createdUserService.saveUser(user);
        System.out.println("Created New User :: " + savedUser);
        if(savedUser != null) {
            System.out.println("User Created :: " + savedUser);
            return new ResponseEntity<>("Signup successfull", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("SignUp failed", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDetails user) {
    	if(user.getUserid() == null || user.getPassword() == null) {
    		return new ResponseEntity<>("User id or password cannot be null", HttpStatus.BAD_REQUEST);
    	}
    	Optional<UserDetails> optional = validateLoginService.validateLogin(user);
    	if(optional.isPresent()) {
    		UserDetails details = optional.get();
    		if(details.getPassword().equals(user.getPassword())) {
    			System.out.println("Login Successful :: " + details.getUserid());
    			return new ResponseEntity<>("Login successful", HttpStatus.OK);
    		} else {
    			return new ResponseEntity<>("Incorrect Password", HttpStatus.UNAUTHORIZED);
    		}
    	} else {
    		return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    	}
    }
}

package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.User;
import com.project.demo.service.UserSerivce;

@RestController
public class UserController {

	@Autowired
	private UserSerivce service;
	
	@Autowired
	AuthenticationManager authenticationManger;
	
	//for rigestration
	@PostMapping("register")
	public User rigister(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	//for JWT token
	
	@PostMapping("login")
	public String login(@RequestBody User user) {
		Authentication authentication=authenticationManger
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
	
		if(authentication.isAuthenticated())
			return "success";
		else 
			return "login failed";
	
	}
}

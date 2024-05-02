package com.project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.project.demo.model.User;
import com.project.demo.repository.UserRepo;

@Service
public class UserSerivce {

	@Autowired
	private UserRepo repo;
	
	//for bcrypting password creatin a object
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
	
	
	public User saveUser(User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));//encoding password
		System.out.println(user.getPassword());//will get bcrypted password here
		return repo.save(user);
	}
	
}

package com.project.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

	@GetMapping("hello")
	public String greet(HttpServletRequest request) {
		//return "hello This is session ID : " + request.getSession().getId();
	return "hello security JWT";
	
	}
	
	@GetMapping("info")
	public String about() {
		return "created using spring security";
	}
}

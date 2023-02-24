package com.sso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sso.entities.Users;
import com.sso.repositories.UserRepository;

@RestController
public class IndexController {
	@Autowired
	private UserRepository usersRepository;
	
	@GetMapping("")
	public String getIndex() {
		return "Login Success";
	}
	
	@GetMapping("/secured-url")
	public String getSecuredUrl() {
		return "Secured URL. Just logged persons can access here.";
	}
	
	@GetMapping("/free-url")
	public String getFreeUrl() {
		return "Free URL. Everybody can access here without login.";
	}
	
	@GetMapping("/users")
	public Iterable<Users> getUsuario() {
		return usersRepository.findAll();
	}	
}
package com.sso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sso.entities.Users;
import com.sso.repositories.UserRepository;

public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = userRepository.findById(username).get();
		
		if(users == null) {
			throw new UsernameNotFoundException("User doesn't exists");
		}
		
		User user = new User(username, users.getPassword(), true, true, true, true, users.getRoles());
		return user;
	}
}
package com.sso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	@Autowired 
	private MyUserDetailsService myUserDetailsService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String credentials = (String)authentication.getCredentials();
		User user = (User) myUserDetailsService.loadUserByUsername(username);
		
		if(user != null) {
			if(credentials.equals(user.getPassword())) {
				return new UsernamePasswordAuthenticationToken(user, credentials, user.getAuthorities());
			}else{
				throw new BadCredentialsException("The Password is inncorrect");
			}
		}else{
			throw new BadCredentialsException("User doesn't exists.");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
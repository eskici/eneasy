package com.moss.project.eneasy.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.AuthenticationException;
import org.springframework.security.BadCredentialsException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;
import org.springframework.security.providers.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.userdetails.UserDetails;

import com.moss.project.eneasy.dao.UserDAO;
import com.moss.project.eneasy.model.UserEntity;

public class MyAuthenticationProvider extends   AbstractUserDetailsAuthenticationProvider {
	private static final Log log = LogFactory.getLog(MyAuthenticationProvider.class);
	
	@Autowired 
	private UserDAO userDAO;
		
	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0,
			UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
		System.out.println();
		
	}

	@Override
	protected UserDetails retrieveUser(String userName,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		
			UserEntity registeredUser= userDAO.readUserEntity(userName);
			if(registeredUser!=null && registeredUser.getPassword().equals(authentication.getCredentials().toString())){ 

				String role = registeredUser.getRole();
				GrantedAuthority[] arr= {new GrantedAuthorityImpl(role)};
				org.springframework.security.userdetails.User user= new org.springframework.security.userdetails.User(userName,authentication.getCredentials().toString(), true, true, true, true,arr);
				return user;
			} else 
				throw new BadCredentialsException("olmadi");			
	}
	
}

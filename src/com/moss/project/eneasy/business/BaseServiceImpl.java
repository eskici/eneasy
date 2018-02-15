package com.moss.project.eneasy.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.User;

import com.moss.project.eneasy.dao.UserDAO;
import com.moss.project.eneasy.model.UserEntity;
import com.moss.project.eneasy.util.MyConstants;

public class BaseServiceImpl implements IBaseService,MyConstants{

	@Autowired
	private UserDAO userDAO;


	public  UserEntity getCurrentUser() {

	    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	    if (principal instanceof User && principal != null){
	    	User user  = (User)principal;
	    	return userDAO.readUserEntity(user.getUsername());
	    }
	    
	    return null;
	}

	
}

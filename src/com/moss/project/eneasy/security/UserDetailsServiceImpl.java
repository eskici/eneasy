package com.moss.project.eneasy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moss.project.eneasy.dao.UserDAO;
import com.moss.project.eneasy.model.UserEntity;

@Service("userDetailsService") 
public class UserDetailsServiceImpl implements UserDetailsService {


	@Autowired private UserDAO userDAO;
	  @Autowired private Assembler assembler;

  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException, DataAccessException {

    UserEntity userEntity = userDAO.findByName(username);
    if (userEntity == null)
      throw new UsernameNotFoundException("user not found");

    return  assembler.buildUserFromUserEntity(userEntity);
  }
  

  public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public Assembler getAssembler() {
		return assembler;
	}

	public void setAssembler(Assembler assembler) {
		this.assembler = assembler;
	}

}
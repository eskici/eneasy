package com.moss.project.eneasy.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.moss.project.eneasy.dao.UserDAO;
import com.moss.project.eneasy.model.UserEntity;
import com.moss.project.eneasy.util.MyConstants;

public class UserServiceImpl implements IUserService,MyConstants{

	@Autowired
	private UserDAO userDAO;
	
	public List<UserEntity> readLastUserEntitys() {
		// TODO Auto-generated method stub
		return userDAO.readLastUserEntitys();
	}

	public void approveUserEntity(String objid) {
		// TODO Auto-generated method stub
		UserEntity topic = userDAO.readUserEntity(objid);
		topic.setStatus("ON");
		userDAO.updateUserEntity(topic);		
	}

	public void cancelUserEntity(String objid) {
		// TODO Auto-generated method stub
		UserEntity topic = userDAO.readUserEntity(objid);
		topic.setStatus("IP");
		userDAO.updateUserEntity(topic);
	}

	public void addNewUserEntity(UserEntity user) {
		// TODO Auto-generated method stub
		userDAO.addNewUserEntity(user);
	}

	public UserEntity readUserEntity(String objid) {
		// TODO Auto-generated method stub
		return userDAO.readUserEntity(objid);
	}

	public List<UserEntity> readWaitingUserEntitys() {
		// TODO Auto-generated method stub
		return userDAO.readWaitingUserEntitys();
	}

	public List<UserEntity> searchUserEntity(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}	
}

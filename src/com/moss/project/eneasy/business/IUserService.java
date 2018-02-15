package com.moss.project.eneasy.business;

import java.util.List;

import com.moss.project.eneasy.model.UserEntity;

public interface IUserService {
	List<UserEntity> readLastUserEntitys();
	void approveUserEntity(String objid);
	void cancelUserEntity(String objid);
	void addNewUserEntity(UserEntity user);
	UserEntity readUserEntity(String objid);
	List<UserEntity> readWaitingUserEntitys();
	public List<UserEntity> searchUserEntity(String title);
}

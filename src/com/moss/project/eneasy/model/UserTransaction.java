package com.moss.project.eneasy.model;

import java.util.Set;

public class UserTransaction extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserEntity user;
	private Set<Entry> entries;
	private Set<Topic> topics;	

	public UserTransaction() {
		// TODO Auto-generated constructor stub
	}
	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Set<Entry> getEntries() {
		return entries;
	}

	public void setEntries(Set<Entry> entries) {
		this.entries = entries;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

}

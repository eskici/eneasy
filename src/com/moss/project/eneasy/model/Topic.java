package com.moss.project.eneasy.model;

import java.util.Set;
public class Topic  extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4225190457422196558L;

	private String name;
	private String status;
	private UserEntity createdBy;

	private Set<Entry> entries;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}




	public Set<Entry> getEntries() {
		return entries;
	}

	public void setEntries(Set<Entry> entries) {
		this.entries = entries;
	}

	public UserEntity getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserEntity createdBy) {
		this.createdBy = createdBy;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Topic name " +name+"\n"+
						"Topic stat " +status+"\n";
	}
}

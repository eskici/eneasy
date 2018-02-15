package com.moss.project.eneasy.model;

import java.util.Date;

public class Entry extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3522370151651536686L;
	private String content;
	private String status;
	private Date creationDate;
	private UserEntity createdBy;
	private Topic topic;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public UserEntity getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserEntity createdBy) {
		this.createdBy = createdBy;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}

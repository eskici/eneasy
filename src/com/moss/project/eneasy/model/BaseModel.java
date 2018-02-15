package com.moss.project.eneasy.model;

import java.io.Serializable;
import java.util.Date;

import com.moss.project.eneasy.util.MyConstants;

public class BaseModel implements Serializable,MyConstants{
	/**
	 * 
	 */
	
	public BaseModel() {
		// TODO Auto-generated constructor stub
		this.setRecordStatus(RECORD_STATUS_ACTIVE);
		this.setCreationDate(new Date());
	}
	
	private static final long serialVersionUID = 1L;
	private Date creationDate;
	private Date lastChangeDate;
	private String recordStatus;
	private String objid;

	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastChangeDate() {
		return lastChangeDate;
	}

	public void setLastChangeDate(Date lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}
	
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}


	public String getObjid() {
		return objid;
	}

	public void setObjid(String objid) {
		this.objid = objid;
	}
}

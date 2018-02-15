package com.moss.project.eneasy.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Set;

import org.hibernate.Hibernate;

public class UserEntity extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String role;
	private String status;
	private String email;
	private Set<Entry> entries;
	private Set<Topic> topics;
	private byte[] avatar;
	
	public UserEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public UserEntity(String username, String password,String role,String status,String email) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
		this.role = role;
		this.status = status;
		this.email = email;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	
	 public void setAvatarBlob(Blob resume) {  
		   this.avatar = this.toByteArray(resume); 
		  } 
		  
		  /** Don't invoke this.  Used by Hibernate only. */ 
		  public Blob getAvatarBlob() {  
		   return Hibernate.createBlob(this.avatar); 
		  }
		  
	private byte[] toByteArray(Blob fromBlob) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			return toByteArrayImpl(fromBlob, baos);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException ex) {
				}
			}
		}
	}

	private byte[] toByteArrayImpl(Blob fromBlob, ByteArrayOutputStream baos)
			throws SQLException, IOException {
		byte[] buf = new byte[4000];
		InputStream is = fromBlob.getBinaryStream();
		try {
			for (;;) {
				int dataSize = is.read(buf);
				if (dataSize == -1)
					break;
				baos.write(buf, 0, dataSize);
			}
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException ex) {
				}
			}
		}
		return baos.toByteArray();
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

}		  


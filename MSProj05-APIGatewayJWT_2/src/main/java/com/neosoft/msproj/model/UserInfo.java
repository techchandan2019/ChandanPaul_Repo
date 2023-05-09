package com.neosoft.msproj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserInfo11")
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer unId;
	private String username;
	private String password;
	
	public UserInfo() {
		// TODO Auto-generated constructor stub
	}
	public UserInfo(Integer unId, String username, String password) {
		this.unId = unId;
		this.username = username;
		this.password = password;
	}
	public Integer getUnId() {
		return unId;
	}
	public void setUnId(Integer unId) {
		this.unId = unId;
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
	@Override
	public String toString() {
		return "UserInfo [unId=" + unId + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
	

}

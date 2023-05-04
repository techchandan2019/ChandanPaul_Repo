package com.neosoft.msproj.model;

import javax.validation.constraints.NotBlank;

public class UserDetail {
	
	@NotBlank(message = "username required")
	private String usn;
	@NotBlank(message = "password required")
	private String pwd;
	
	public UserDetail() {
		// TODO Auto-generated constructor stub
	}
	public UserDetail(String usn, String pwd) {
		super();
		this.usn = usn;
		this.pwd = pwd;
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "UserDetail [usn=" + usn + ", pwd=" + pwd + "]";
	}
	
	
	

}

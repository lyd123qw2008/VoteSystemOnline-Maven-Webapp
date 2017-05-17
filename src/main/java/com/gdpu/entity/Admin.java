package com.gdpu.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class Admin implements java.io.Serializable {

	private Integer adminId;
	private String userName;
	private String password;
	private Date logintime;

	public Admin() {
	}

	public Admin(String userName, String password, Date logintime) {
		this.userName = userName;
		this.password = password;
		this.logintime = logintime;
	}
	
	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLogintime() {
		return this.logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", userName=" + userName + ", password="
				+ password + ", logintime=" + logintime + "]";
	}

}
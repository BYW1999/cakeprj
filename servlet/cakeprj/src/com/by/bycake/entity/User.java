package com.by.bycake.entity;

import java.util.Date;

public class User {
	private String usermail;
	private String username;
	private String userfaname;
	private String password;
	private String registertime;
	
	public User() {
		
	}
	
	public User(String usermail, String username, String userfaname, String password, String registertime) {
		super();
		this.usermail = usermail;
		this.username = username;
		this.userfaname = userfaname;
		this.password = password;
		this.registertime = registertime;
	}
	
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUserfaname() {
		return userfaname;
	}
	public void setUserfaname(String userfaname) {
		this.userfaname = userfaname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegistertime() {
		return registertime;
	}
	public void setRegistertime(String registertime) {
		this.registertime = registertime;
	}
	@Override
	public String toString() {
		return "User [usermail=" + usermail + ", username=" + username + ", userfaname=" + userfaname + ", password="
				+ password + ", registertime=" + registertime + "]";
	}
	
}

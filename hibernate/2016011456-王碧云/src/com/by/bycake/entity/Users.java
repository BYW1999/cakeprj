package com.by.bycake.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="user")
public class Users {
	private String usermail;
	private String username;
	private String userfaname;
	private String password;
	private Date registertime;
	
	public Users() {
		
	}
	
	public Users(String usermail, String username, String userfaname, String password, Date registertime) {
		super();
		this.usermail = usermail;
		this.username = username;
		this.userfaname = userfaname;
		this.password = password;
		this.registertime = registertime;
	}
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
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
	public Date getRegistertime() {
		return registertime;
	}
	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}
	
}

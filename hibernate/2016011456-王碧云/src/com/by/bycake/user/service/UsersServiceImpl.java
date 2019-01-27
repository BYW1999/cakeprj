package com.by.bycake.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.by.bycake.entity.Users;
import com.by.bycake.user.Dao.UsersDaoImpl;

@Service
@Transactional
public class UsersServiceImpl {
	@Resource
	private UsersDaoImpl usersDaoImpl;
	
	//获取所有的用户
	public List<Users> findAllUsers(){
		return this.usersDaoImpl.findAllUsers();
	}
	//确认用户
	public Users confirmUser(String email){
		return this.usersDaoImpl.confirmUser(email);
	}
	//插入新的用户
	public void AddUser(String usermail,String username,String userfaname,String password) {
		this.usersDaoImpl.AddUser(usermail, username, userfaname, password);
	}
}

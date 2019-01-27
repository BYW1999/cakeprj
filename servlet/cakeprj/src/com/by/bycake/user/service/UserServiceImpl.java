package com.by.bycake.user.service;

import java.util.List;

import com.by.bycake.entity.User;
import com.by.bycake.user.Dao.UserDaoImpl;

public class UserServiceImpl {
	
	public List<User> listUser(){
		UserDaoImpl udi = new UserDaoImpl();
		return udi.findAllUser();
	}
	
	public int InsertUser(User u) {
		UserDaoImpl udi = new UserDaoImpl();
		return udi.InsertNewUser(u);
	}
	
	public User confirmUser(String email) {
		UserDaoImpl udi = new UserDaoImpl();
		return udi.confirmLoginUser(email);
	}
	
	/*public Boolean confirmEmail(String email) {
		UserDaoImpl udi = new UserDaoImpl();
		Boolean bool = false;
		User user=udi.confirmLoginUser(email);
		if(user!=null) {
			if(user.getUsermail().equals(email)) {
				bool=true;//该邮箱已被注册
			}
		}
		return bool;
	}*/
}

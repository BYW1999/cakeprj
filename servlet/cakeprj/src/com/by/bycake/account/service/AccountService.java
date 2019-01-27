package com.by.bycake.account.service;

import com.by.bycake.entity.User;
import com.by.bycake.user.service.UserServiceImpl;

public class AccountService {
	
	public boolean ifHaveSameMail(String email) {
		UserServiceImpl usi = new UserServiceImpl();
		User user = usi.confirmUser(email);	//返回与用户email对应的user
		Boolean haveuser = false;
		if(user!=null) {
			//已有与该邮箱相同的用户，即该邮箱已经被注册
			haveuser = true;
		}
		return haveuser;
	}
}

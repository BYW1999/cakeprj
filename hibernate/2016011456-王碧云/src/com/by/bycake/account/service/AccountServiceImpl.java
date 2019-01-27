package com.by.bycake.account.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.by.bycake.entity.Users;
import com.by.bycake.user.service.UsersServiceImpl;

@Service
@Transactional
public class AccountServiceImpl {
	
	@Resource
	private UsersServiceImpl usersServiceImpl;
	
	public String VerifyUser(String usermail,String username,String userfaname,String password,String repassword) {
		Users user = this.usersServiceImpl.confirmUser(usermail);

		if(user!=null || !password.equals(repassword)) {	//邮箱已被注册或密码不一致
			System.out.println("已有邮箱/密码不一致");
			return "account";
		}else {		//邮箱未被注册
			//插入用户
			this.usersServiceImpl.AddUser(usermail, username, userfaname, repassword);
			return "first";
		}
	}
	
	public String theName(String path,String userfaname,String username) {
		String name="";
		if(path.equals("first")) {
			name=userfaname+username;
		}
		return name;
	}
	
}

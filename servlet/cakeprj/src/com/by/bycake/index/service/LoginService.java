package com.by.bycake.index.service;

import java.util.List;

import com.by.bycake.entity.User;
import com.sun.org.apache.regexp.internal.recompile;

public class LoginService {

	public String ifCakeUser(List<User> userlist,String email,String pwd) {
		String name=null;
		for(User u:userlist) {
			if(u.getUsermail().equals(email) && u.getPassword().equals(pwd)) {
				//登陆成功
				System.out.println("成功");
				String userfaname = u.getUserfaname();
				String username = u.getUsername();
				name = userfaname + username;
				
			}else {
				//登录失败
				System.out.println("失败"); 
				
			}
		}
		return name;
	}
	
	public String confirmCakeUser(User user,String email,String pwd) {
		String name=null;
		if(user!=null) {
			String usermail = user.getUsermail();
			String password = user.getPassword();
			if(usermail.equals(email) && password.equals(pwd)) {
				//登陆成功
				System.out.println("成功");
				String userfaname = user.getUserfaname();
				String username = user.getUsername();
				name = userfaname + username;
			}
			else {
				System.out.println("账号或密码错误");
			}
		}else {
			//没有对应的用户
			System.out.println("邮箱不正确");
		}
		return name;
	}
	
}

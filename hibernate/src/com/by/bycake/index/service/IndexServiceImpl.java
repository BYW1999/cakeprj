package com.by.bycake.index.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.by.bycake.entity.Users;

@Service
@Transactional(readOnly=true)
public class IndexServiceImpl {
	
	public String ifCakeUser(List<Users> userlist,String email,String pwd) {
		String name=null;
		for(Users u:userlist) {
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
	
	public String confirmCakeUser(Users user,String email,String pwd) {
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

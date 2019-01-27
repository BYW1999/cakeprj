package com.by.bycake.account.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.by.bycake.account.service.AccountServiceImpl;
import com.by.bycake.user.service.UsersServiceImpl;

@Controller
public class AccountController {
	@Resource
	private UsersServiceImpl usersServiceImpl;
	@Resource
	private AccountServiceImpl accountServiceImpl;
	
	/*
	 * usermail 用户输入的邮箱
	 * username 用户输入的名字
	 * userfaname 用户输入的姓氏
	 * password 用户输入的密码
	 * repassword 用户输入的确认密码
	 */
	@RequestMapping("/accountController")
	public String accountController(@RequestParam("emailadd") String usermail,
			@RequestParam("lastname") String username,
			@RequestParam("firstname") String userfaname,
			@RequestParam("registerpassword") String password,
			@RequestParam("confirmpassword") String repassword,
			HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charSet=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String repath = this.accountServiceImpl.VerifyUser(usermail, username, userfaname, password, repassword);	//对注册的用户进行验证
		HttpSession session = request.getSession();
		String name = this.accountServiceImpl.theName(repath, userfaname, username);
		session.setAttribute("name",name);
		
		return repath;
	}
	
}

package com.by.bycake.index.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.by.bycake.cake.service.CakeServiceImpl;
import com.by.bycake.entity.Cake;
import com.by.bycake.entity.CakeType;
import com.by.bycake.entity.Users;
import com.by.bycake.index.service.IndexServiceImpl;
import com.by.bycake.type.service.TypeServiceImpl;
import com.by.bycake.user.service.UsersServiceImpl;

@Controller
public class IndexController {

	@Resource
	private TypeServiceImpl typeServiceImpl;
	@Resource
	private CakeServiceImpl cakeServiceImpl;
	@Resource
	private UsersServiceImpl usersServiceImpl;
	@Resource
	private IndexServiceImpl indexServiceImpl;
	
	@RequestMapping("/indexController")
	public String indexController(HttpServletRequest request) {
		List<CakeType> typelist = this.typeServiceImpl.listType();
		request.getServletContext().setAttribute("typelist", typelist);
		
		//显示销售量前八的蛋糕
		HttpSession session = request.getSession();
		List<Cake> topcakelist = this.cakeServiceImpl.findTopOrderCake();
		session.setAttribute("topcakelist", topcakelist);
		
		return "index";
	}
	
	/*
	 * email 用户输入的邮箱
	 * pwd 用户输入的密码
	*/
	@RequestMapping("/loginController")
	public String loginController(@RequestParam("email") String email,
			@RequestParam("password") String pwd,
			HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charSet=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//用户登录	
		Users users = this.usersServiceImpl.confirmUser(email);//返回与用户email对应的users
		String name = this.indexServiceImpl.confirmCakeUser(users, email, pwd);
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		return "first";
	}
}

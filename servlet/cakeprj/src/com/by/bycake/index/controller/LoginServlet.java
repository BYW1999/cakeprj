package com.by.bycake.index.controller;

import java.io.IOException;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.by.bycake.entity.User;
import com.by.bycake.index.service.LoginService;
import com.by.bycake.user.service.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charSet=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//用户登录
		String email = request.getParameter("email");	//获取用户输入的邮箱
		String pwd = request.getParameter("password");	//获取用户输入的密码
		UserServiceImpl usi = new UserServiceImpl();
		User user = usi.confirmUser(email);	//返回与用户email对应的user
		LoginService ls = new LoginService();
		String name = ls.confirmCakeUser(user, email, pwd);
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		request.getRequestDispatcher("first.jsp").forward(request, response);
	}

}

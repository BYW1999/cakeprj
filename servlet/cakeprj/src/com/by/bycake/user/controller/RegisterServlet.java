package com.by.bycake.user.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.by.bycake.entity.User;
import com.by.bycake.user.service.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String registerdate=sdf.format(date);
		
		String usermail=request.getParameter("emailadd");
		String username=request.getParameter("lastname");
		String userfaname=request.getParameter("firstname");
		String password=request.getParameter("registerpassword");
		String repassword=request.getParameter("confirmpassword");
		String name=userfaname+username;
		
	
		UserServiceImpl usi = new UserServiceImpl();
		User bool = usi.confirmUser(usermail);
		
		if(bool!=null || !password.equals(repassword)) {	//邮箱已被注册或密码不一致
			System.out.println("已有邮箱/密码不一致");
			request.getRequestDispatcher("account.jsp").forward(request, response);
		}else {		//邮箱未被注册
			//用户插入
			User user = new User(usermail, username, userfaname, password,registerdate);
			usi.InsertUser(user);
			HttpSession session = request.getSession();
			session.setAttribute("name",name);
			request.getRequestDispatcher("first.jsp").forward(request, response);
		}
		
	}

}

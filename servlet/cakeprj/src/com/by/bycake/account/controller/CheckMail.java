package com.by.bycake.account.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.by.bycake.account.service.AccountService;

/**
 * Servlet implementation class CheckMail
 */
@WebServlet("/CheckMail")
public class CheckMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckMail() {
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
		String usermail = request.getParameter("usermail");
		System.out.println(usermail);
		AccountService as = new AccountService();
		boolean haveuser=as.ifHaveSameMail(usermail);
		if(haveuser) {
			response.getWriter().print("fail");
		}else {
			response.getWriter().println("ok");
		}
	}

}

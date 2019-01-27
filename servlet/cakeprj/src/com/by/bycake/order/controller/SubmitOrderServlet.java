package com.by.bycake.order.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.by.bycake.cart.entity.CartItem;
import com.by.bycake.order.service.AddOrder;

/**
 * Servlet implementation class SubmitOrderServlet
 */
@WebServlet("/SubmitOrderServlet")
public class SubmitOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitOrderServlet() {
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
		
		//编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charSet=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//获取购物车订单信息
		String usermail = request.getParameter("usermail");
		String addr = request.getParameter("addr");
		String phone = request.getParameter("phone");
		String status = request.getParameter("status");
		
		HttpSession session = request.getSession();
		Object cart = session.getAttribute("cart");
		
		//将购物车里的商品加入订单表和订单明细表
		AddOrder addOrder = new AddOrder();
		addOrder.AddOrderTable(cart,usermail,addr,phone,status);
		
		request.getRequestDispatcher("finish.jsp").forward(request, response);
	}

}

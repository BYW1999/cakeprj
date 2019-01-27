package com.by.bycake.cart.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.by.bycake.cart.entity.Cart;
import com.by.bycake.cart.service.CartService;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
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
		//将商品添加到购物车
		HttpSession session = request.getSession();
		String cakeid = request.getParameter("cakeid");
		Object obj = session.getAttribute("cart");
		CartService cs = new CartService();
		Cart cart = cs.cakeAddToCart(cakeid, obj);
		session.setAttribute("cart", cart);

		request.getRequestDispatcher("ProductsServlet").forward(request, response);
	}

}

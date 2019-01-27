package com.by.bycake.cart.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.by.bycake.cart.service.CartServiceImpl;
import com.by.bycake.entity.Cart;

@Controller
public class CartController {

	@Resource
	private CartServiceImpl cartServiceImpl;
	
	@RequestMapping("/cartController")
	public void cartController(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//将商品添加到购物车
		HttpSession session = request.getSession();
		String cakeid = request.getParameter("cakeid");
		Object obj = session.getAttribute("cart");
		Cart cart = this.cartServiceImpl.cakeAddToCart(cakeid, obj);
		
		session.setAttribute("cart", cart);
		request.getRequestDispatcher("productsController").forward(request, response);
	}
	
}

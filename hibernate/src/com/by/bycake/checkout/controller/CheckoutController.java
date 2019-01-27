package com.by.bycake.checkout.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.by.bycake.checkout.service.CheckoutServiceImpl;

@Controller
public class CheckoutController {

	@Resource
	private CheckoutServiceImpl checkoutServiceImpl;
	
	/*
	 * usermail 用户邮箱
	 * addr 用户地址
	 * phone 用户电话
	 * status 用户状态
	 */
	@RequestMapping("/checkoutController")
	public String checkoutController(@RequestParam("usermail") String usermail,
			@RequestParam("addr") String addr,
			@RequestParam("phone") String phone,
			@RequestParam("status") String status,
			HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		//编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charSet=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取购物车
		HttpSession session = request.getSession();
		Object cart = session.getAttribute("cart");
		
		//将购物车里的商品加入订单表和订单明细表
		this.checkoutServiceImpl.AddOrderTable(cart, usermail, addr, phone, status);
		return "finish";
	}
	
}

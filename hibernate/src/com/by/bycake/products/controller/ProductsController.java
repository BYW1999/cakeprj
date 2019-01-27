package com.by.bycake.products.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.by.bycake.entity.Cake;
import com.by.bycake.entity.Page;
import com.by.bycake.products.service.ProductsServiceImpl;

@Controller
public class ProductsController {

	@Resource
	private ProductsServiceImpl productsServiceImpl;
	
	/*
	 * typeid 蛋糕类型
	 * pageNum 页数
	 * cakename 蛋糕名字
	 */
	
	@RequestMapping("/productsController")
	public String productsController(@RequestParam("typeid") String typeid,
				@RequestParam("pageNum") String pageNum,
				@RequestParam("cakename") String cakename,
				HttpServletRequest request,
				HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charSet=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//根据参数返回对应的蛋糕和页面	
		Page<Cake> p = this.productsServiceImpl.checkCake(typeid, pageNum, cakename);
		
		//存取参数
		request.setAttribute("page", p);
		request.setAttribute("typeid", typeid);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("cakename", cakename);

		return "products";
	}
	
}

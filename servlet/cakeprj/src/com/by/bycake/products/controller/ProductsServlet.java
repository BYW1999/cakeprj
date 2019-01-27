package com.by.bycake.products.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.by.bycake.entity.Cake;
import com.by.bycake.entity.Page;
import com.by.bycake.products.service.ProductsService;

/**
 * Servlet implementation class ProductsServlet
 */
@WebServlet("/ProductsServlet")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsServlet() {
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
		
		//获取参数
		String typeid = request.getParameter("typeid");	//获取蛋糕类型
		String pageNum = request.getParameter("pageNum");	//获取页数
		String cakename = request.getParameter("cakename"); //获取蛋糕名字
		ProductsService ps = new ProductsService();		
		Page<Cake> p=ps.checkCake(typeid, pageNum,cakename);
		
		//存取参数
		request.setAttribute("page", p);
		request.setAttribute("typeid", typeid);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("cakename", cakename);
		request.getRequestDispatcher("products.jsp").forward(request, response);
	}

}

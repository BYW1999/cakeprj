package com.by.bycake.single.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.by.bycake.cake.service.CakeService;
import com.by.bycake.common.service.CommentService;
import com.by.bycake.entity.Cake;
import com.by.bycake.entity.Comment;

/**
 * Servlet implementation class SingleServlet
 */
@WebServlet("/SingleServlet")
public class SingleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleServlet() {
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
		//获取对应的商品id
		String cakeid = request.getParameter("cakeid");
		//根据商品id返回商品
		CakeService cs = new CakeService();
		Cake cake = cs.findCakeByCakeid(Integer.parseInt(cakeid));
		//根据商品id返回评论
		CommentService commentService = new CommentService();
		List<Comment> commentlist = commentService.findCommentByCakeId(Integer.parseInt(cakeid));
		request.setAttribute("commentlist", commentlist);
		
		request.setAttribute("singlecake", cake);
		request.getRequestDispatcher("single.jsp").forward(request, response);
	}

}

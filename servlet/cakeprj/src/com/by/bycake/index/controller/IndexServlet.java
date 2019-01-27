package com.by.bycake.index.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.by.bycake.entity.Cake;
import com.by.bycake.entity.Type;
import com.by.bycake.entity.User;
import com.by.bycake.order.service.OrdermanageService;
import com.by.bycake.type.service.TypeService;
import com.by.bycake.user.service.UserServiceImpl;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
		//蛋糕类型(显示菜单栏)
		TypeService ts=new TypeService();
		List<Type> typelist=ts.listType();
		HttpSession session = request.getSession();
		session.setAttribute("typelist", typelist);
		
		//显示销售量前八的蛋糕
		OrdermanageService os = new OrdermanageService();
		List<Cake> topcakelist = os.findTopOrderCake();
		session.setAttribute("topcakelist", topcakelist);
	
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}

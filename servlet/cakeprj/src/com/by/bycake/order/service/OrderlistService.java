package com.by.bycake.order.service;

import java.util.List;

import com.by.bycake.entity.Cake;
import com.by.bycake.entity.Orderlist;
import com.by.bycake.entity.User;
import com.by.bycake.order.dao.OrderlistDao;

public class OrderlistService {
	
	//返回订单表的所有订单
	public List<Orderlist> findAllOrderList(){
		OrderlistDao ol = new OrderlistDao();
		return ol.findAllOrder();
	}
	
	//将购物车蛋糕插入订单表
	public int addOrderlist(Orderlist orderlist) {
		OrderlistDao ol = new OrderlistDao();
		return ol.addOrderlist(orderlist);
	}
}
	

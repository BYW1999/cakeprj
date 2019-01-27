package com.by.bycake.order.service;

import java.util.List;

import com.by.bycake.entity.Cake;
import com.by.bycake.entity.Ordermanage;
import com.by.bycake.order.dao.OrdermanageDao;

public class OrdermanageService {
	
	//返回订单明细表的订单列表
	public List<Ordermanage> findAllOrdermanageList(){
		OrdermanageDao od = new OrdermanageDao();
		return od.findAllOrdermanage();
	}
	
	//返回销量前八的蛋糕
	public List<Cake> findTopOrderCake(){
		OrdermanageDao od = new OrdermanageDao();
		return od.findTopOrderCake();
	}
	
	//将购物车蛋糕加入订单明细表
	public void addOrdermanager(List<Ordermanage> ordermanagelist) {
		OrdermanageDao od = new OrdermanageDao();
		//return od.addOrdermanager(ordermanage);
		for(Ordermanage o:ordermanagelist) {
			od.addOrdermanager(o);
		}
	}
}

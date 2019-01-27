package com.by.bycake.order.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.by.bycake.entity.Orderlist;
import com.by.bycake.order.dao.OrderlistDaoImpl;
@Service
@Transactional
public class OrderlistServiceImpl {
	@Resource
	private OrderlistDaoImpl orderlistDaoImpl;
	
	//返回所有的订单
	public List<Orderlist> findAllOrderlist(){
		return this.orderlistDaoImpl.findAllOrderlist();
	}
	//将购物车蛋糕插入订单表（返回自增主键）
	public int addCakeIntoOrderlist(String usermail,String addr,String phone,int status) {
		return this.orderlistDaoImpl.addCakeIntoOrderlist(usermail, addr, phone, status);
	}
}

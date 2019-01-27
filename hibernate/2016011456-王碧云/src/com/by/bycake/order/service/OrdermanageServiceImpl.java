package com.by.bycake.order.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.by.bycake.entity.Ordermanage;
import com.by.bycake.order.dao.OrdermanageDaoImpl;

@Service
@Transactional
public class OrdermanageServiceImpl {
	@Resource
	private OrdermanageDaoImpl ordermanageDaoImpl;
	
	//返回订单明细表的所有订单详情
	public List<Ordermanage> findAllOrdermanage(){
		return this.ordermanageDaoImpl.findAllOrdermanage();
	}
	//将购物车蛋糕加入订单明细表
	public void addOrdermanage(int orderid,int cakeid,int amount) {
		this.ordermanageDaoImpl.addOrdermanage(orderid, cakeid, amount);
	}
	
}

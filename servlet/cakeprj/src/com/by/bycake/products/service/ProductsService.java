package com.by.bycake.products.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.by.bycake.cake.service.CakeService;
import com.by.bycake.cart.entity.Cart;
import com.by.bycake.cart.entity.CartItem;
import com.by.bycake.entity.Cake;
import com.by.bycake.entity.Orderlist;
import com.by.bycake.entity.Ordermanage;
import com.by.bycake.entity.Page;
import com.by.bycake.entity.User;
import com.by.bycake.order.service.OrderlistService;
import com.by.bycake.order.service.OrdermanageService;

public class ProductsService{
	
	public Page<Cake> checkCake(String typeid,String pageNum,String cakename){	
		int num = 0;
		if(pageNum==null || pageNum.equals("")) {
			num = 1;
		}else {
			num = Integer.parseInt(pageNum);
		}
	
		if(typeid != null && !"".equals(typeid)) {	//存在typeid查找   || !"".equals(typeid)  || typeid.length() >0
			CakeService cs = new CakeService();
			int count = cs.findCakeCountByTypeid(Integer.parseInt(typeid));		//获得蛋糕数量
			List<Cake> list = cs.findCakeByTypeid(Integer.parseInt(typeid),num, 6);	//获得分页的蛋糕
			Page<Cake> p = new Page<Cake>(num,6);	//创建Page对象p进行分页
			p.setList(list); 						//设置p列表的蛋糕
			p.setTotalCount(count);					//设置p的蛋糕数量
			return p;
		}else if(cakename != null && !"".equals(cakename)) {	//存在cakename查找    || !"".equals(cakename)  || cakename.length() > 0
			CakeService cs = new CakeService();
			int count = cs.findCakeCountByCakename(cakename);
			List<Cake> list = cs.findCakeByCakename(cakename, num, 6);
			Page<Cake> p = new Page<Cake>(num,6);
			p.setList(list); 	
			p.setTotalCount(count);
			return p;
		}else {		
			CakeService cs = new CakeService();
			int count = cs.findCakeCount();	
			List<Cake> list = cs.findByPage(num,6);
			Page<Cake> p = new Page<Cake>(num,6);
			p.setList(list); 	
			p.setTotalCount(count);
			return p;
		}

	}
	
	
	
}

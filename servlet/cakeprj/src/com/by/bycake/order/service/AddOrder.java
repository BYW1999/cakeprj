package com.by.bycake.order.service;

import java.util.ArrayList;
import java.util.List;

import com.by.bycake.cart.entity.Cart;
import com.by.bycake.cart.entity.CartItem;
import com.by.bycake.entity.Orderlist;
import com.by.bycake.entity.Ordermanage;

public class AddOrder {
	
	//判断购物车是否为空，如果不为空，则将商品加入订单表和订单明细表
		public void AddOrderTable(Object obj,String usermail,String addr,String phone,String status) {
			Cart cart = null; 
			Orderlist orderlist = new Orderlist(usermail,addr,phone,Integer.parseInt(status));
			List<Ordermanage> ordermanagelist = new ArrayList<Ordermanage>();
			
			if(obj!=null) {
				cart = (Cart)obj;
				for(Integer key:cart.getContainer().keySet()) {
					int cartid = key;
					CartItem ci = cart.getContainer().get(key);
					int count = ci.getCount();
					Ordermanage om = new Ordermanage(orderlist.getOrderid(),cartid,count);
					ordermanagelist.add(om);
				}
				OrderlistService ols = new OrderlistService();
				ols.addOrderlist(orderlist);
				OrdermanageService oms = new OrdermanageService();
				oms.addOrdermanager(ordermanagelist);
			}
			
		}
	
}

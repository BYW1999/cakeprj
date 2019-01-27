package com.by.bycake.checkout.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.by.bycake.entity.Cart;
import com.by.bycake.entity.CartItem;
import com.by.bycake.order.service.OrderlistServiceImpl;
import com.by.bycake.order.service.OrdermanageServiceImpl;

@Service
@Transactional
public class CheckoutServiceImpl {
	@Resource
	private OrderlistServiceImpl orderlistServiceImpl;
	@Resource
	private OrdermanageServiceImpl ordermanageServiceImpl;
	
	//判断购物车是否为空，如果不为空，则将商品加入订单表和订单明细表
	public void AddOrderTable(Object obj,String usermail,String addr,String phone,String status) {
		Cart cart = null; 
		int orderid = this.orderlistServiceImpl.addCakeIntoOrderlist(usermail, addr, phone, Integer.parseInt(status));
		
		if(obj!=null) {
			cart = (Cart)obj;
			for(Integer key:cart.getContainer().keySet()) {
				int cakeid = key;
				CartItem ci = cart.getContainer().get(key);
				int count = ci.getCount();
				this.ordermanageServiceImpl.addOrdermanage(orderid, cakeid, count);
			}
		}
		
	}
	
}

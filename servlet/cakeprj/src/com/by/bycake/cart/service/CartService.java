package com.by.bycake.cart.service;

import com.by.bycake.cake.service.CakeService;
import com.by.bycake.cart.entity.Cart;
import com.by.bycake.entity.Cake;

public class CartService {
	
	//将cakeid对应的商品加入到购物车(如果没有购物车，则创建一个)
	public Cart cakeAddToCart(String cakeid,Object obj) {
		if(cakeid != null && !"".equals(cakeid)) {
			//通过cakeid返回对应的蛋糕
			CakeService cs = new CakeService();
			Cake cake = cs.findCakeByCakeid(Integer.parseInt(cakeid));
			
			Cart cart = null;
			if(obj == null) {
				cart = new Cart();
			}else {
				cart=(Cart)obj;
			}
			cart.add(cake);
			System.out.println("购物车内有："+cart);
			return cart;
		}
		return null;
	}
	
}

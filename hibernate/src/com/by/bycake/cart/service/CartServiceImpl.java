package com.by.bycake.cart.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.by.bycake.cake.service.CakeServiceImpl;
import com.by.bycake.entity.Cake;
import com.by.bycake.entity.Cart;

@Service
@Transactional(readOnly=true)
public class CartServiceImpl {
	@Resource
	private CakeServiceImpl cakeServiceImpl;
	
	//将cakeid对应的商品加入到购物车(如果没有购物车，则创建一个)
	public Cart cakeAddToCart(String cakeid,Object obj) {
		if(cakeid != null && !"".equals(cakeid)) {
			//通过cakeid返回对应的蛋糕
			Cake cake = this.cakeServiceImpl.findCakeByCakeid(Integer.parseInt(cakeid));
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

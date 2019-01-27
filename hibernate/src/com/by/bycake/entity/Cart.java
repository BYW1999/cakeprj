package com.by.bycake.entity;

import java.util.HashMap;

import com.by.bycake.entity.Cake;

public class Cart {
	
	private HashMap<Integer, CartItem> container = new HashMap<Integer, CartItem>();
	
	public void add(Cake cake) {
		if(container.containsKey(cake.getCakeid())) {
			int count = container.get(cake.getCakeid()).getCount() + 1;
			container.get(cake.getCakeid()).setCount(count);
		}else {
			CartItem cartItem = new CartItem();
			cartItem.setCake(cake);
			cartItem.setCount(1);
			container.put(cake.getCakeid(), cartItem);
		}
		
	}

	public HashMap<Integer, CartItem> getContainer() {
		return container;
	}

	public void setContainer(HashMap<Integer, CartItem> container) {
		this.container = container;
	}

	@Override
	public String toString() {
		return "Cart [container=" + container + "]";
	}
	
	
}

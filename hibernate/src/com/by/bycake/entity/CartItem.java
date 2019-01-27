package com.by.bycake.entity;

import com.by.bycake.entity.Cake;

public class CartItem {
	private Cake cake;
	private int count;
	public Cake getCake() {
		return cake;
	}
	public void setCake(Cake cake) {
		this.cake = cake;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CartItem [cake=" + cake + ", count=" + count + "]";
	}
	
	
}

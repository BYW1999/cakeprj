package com.by.bycake.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Ordermanage {
	public static AtomicInteger count = new AtomicInteger(1);
	private int omid;
	private int orderid;
	private int cakeid;
	private int amount;
	
	
	
	public Ordermanage() {
		super();
		this.omid = count.getAndIncrement();
	}
	public Ordermanage(int orderid, int cakeid, int amount) {
		super();
		this.omid = count.getAndIncrement();
		this.orderid = orderid;
		this.cakeid = cakeid;
		this.amount = amount;
	}
	public int getOmid() {
		return omid;
	}
	public void setOmid(int omid) {
		this.omid = omid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getCakeid() {
		return cakeid;
	}
	public void setCakeid(int cakeid) {
		this.cakeid = cakeid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Ordermanage [omid=" + omid + ", orderid=" + orderid + ", cakeid=" + cakeid + ", amount=" + amount + "]";
	}
	
	
	
}

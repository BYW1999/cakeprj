package com.by.bycake.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Orderlist {
	public static AtomicInteger count = new AtomicInteger(1);
	private int orderid;
	private String usermail;
	private String ordertime;
	private String addr;
	private String phone;
	private int status;
	
	
	
	public Orderlist() {
		super();
		this.orderid = count.getAndIncrement();
	}
	
	
	
	public Orderlist(String usermail, String addr, String phone, int status) {
		super();
		this.orderid = count.getAndIncrement();
		this.usermail = usermail;
		this.addr = addr;
		this.phone = phone;
		this.status = status;
	}



	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
		//this.orderid = count.getAndIncrement();
	}
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Otherlist [orderid=" + orderid + ", usermail=" + usermail + ", ordertime=" + ordertime + ", addr="
				+ addr + ", phone=" + phone + ", status=" + status + "]";
	}
	
	
}

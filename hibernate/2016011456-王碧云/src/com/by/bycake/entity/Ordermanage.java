package com.by.bycake.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="ordermanage")
public class Ordermanage {
	private int omid;
	private int amount;
	
	private Orderlist orderlist;
	private Cake cake;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getOmid() {
		return omid;
	}
	public void setOmid(int omid) {
		this.omid = omid;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@ManyToOne
	@JoinColumn(name="orderid")
	public Orderlist getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(Orderlist orderlist) {
		this.orderlist = orderlist;
	}
	
	@ManyToOne
	@JoinColumn(name="cakeid")
	public Cake getCake() {
		return cake;
	}
	public void setCake(Cake cake) {
		this.cake = cake;
	}
	
}

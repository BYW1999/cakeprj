package com.by.bycake.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="orderlist")
public class Orderlist {
	private int orderid;
	private Date ordertime;
	private String addr;
	private String phone;
	private int status;
	
	private Users user;
	private Set<Ordermanage> ordermanages = new HashSet<Ordermanage>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
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
	@ManyToOne(targetEntity=Users.class)
	@JoinColumn(name="usermail")
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@OneToMany(targetEntity=Ordermanage.class,
			cascade= {CascadeType.ALL})
	@JoinColumn(name="orderid")
	public Set<Ordermanage> getOrdermanages() {
		return ordermanages;
	}
	public void setOrdermanages(Set<Ordermanage> ordermanages) {
		this.ordermanages = ordermanages;
	}

}

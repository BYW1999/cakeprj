package com.by.bycake.entity;

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
@Table(name="cake")
public class Cake {
	private int cakeid;
	private String cakename;
	private int cakesize;
	private String cakeintroduce;
	private int cakeprice;
	private int cakediscount;
	private String bigpic;
	private String smapic1;
	private String smapic2;
	private String smapic3;
	private int cakerate;//评级
	private String tag;//标签
	private CakeType cakeType;	//对应的蛋糕类型
	private Set<Comment> comments = new HashSet<Comment>();	//对应的蛋糕评论列表
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCakeid() {
		return cakeid;
	}
	public void setCakeid(int cakeid) {
		this.cakeid = cakeid;
	}
	
	public String getCakename() {
		return cakename;
	}
	public void setCakename(String cakename) {
		this.cakename = cakename;
	}
	
	public int getCakesize() {
		return cakesize;
	}
	public void setCakesize(int cakesize) {
		this.cakesize = cakesize;
	}

	public String getCakeintroduce() {
		return cakeintroduce;
	}
	public void setCakeintroduce(String cakeintroduce) {
		this.cakeintroduce = cakeintroduce;
	}

	public int getCakeprice() {
		return cakeprice;
	}
	public void setCakeprice(int cakeprice) {
		this.cakeprice = cakeprice;
	}
	
	public int getCakediscount() {
		return cakediscount;
	}
	public void setCakediscount(int cakediscount) {
		this.cakediscount = cakediscount;
	}
	
	public String getBigpic() {
		return bigpic;
	}
	public void setBigpic(String bigpic) {
		this.bigpic = bigpic;
	}
	
	public String getSmapic1() {
		return smapic1;
	}
	public void setSmapic1(String smapic1) {
		this.smapic1 = smapic1;
	}
	
	public String getSmapic2() {
		return smapic2;
	}
	public void setSmapic2(String smapic2) {
		this.smapic2 = smapic2;
	}
	
	public String getSmapic3() {
		return smapic3;
	}
	public void setSmapic3(String smapic3) {
		this.smapic3 = smapic3;
	}
	
	public int getCakerate() {
		return cakerate;
	}
	public void setCakerate(int cakerate) {
		this.cakerate = cakerate;
	}
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	@ManyToOne		
	@JoinColumn(name="typeid")
	public CakeType getCakeType() {
		return cakeType;
	}
	public void setCakeType(CakeType cakeType) {
		this.cakeType = cakeType;
	}
	@OneToMany(targetEntity=Comment.class,
			cascade= {CascadeType.ALL})
	@JoinColumn(name="cakeid")
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
}

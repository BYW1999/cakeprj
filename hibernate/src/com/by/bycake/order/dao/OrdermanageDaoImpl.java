package com.by.bycake.order.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.by.bycake.entity.Ordermanage;
import com.by.bycake.util.BaseDao;

/*
 * 实现对订单明细表的增删改查
 */

@Repository
public class OrdermanageDaoImpl extends BaseDao {
	
	//返回订单明细表的所有订单详情
	public List<Ordermanage> findAllOrdermanage(){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Ordermanage");
		return q.list();
	}
	
	//将购物车蛋糕加入订单明细表
	public void addOrdermanage(int orderid,int cakeid,int amount) {
		String sql = "insert into ordermanage(orderid,cakeid,amount) values(?,?,?)";
		this.jdbcTemplate.update(sql,orderid,cakeid,amount);
		System.out.println("[插入ordermanage:orderid:"+orderid+"cakeid"+cakeid+"amount"+amount+"]");
	}
		
}

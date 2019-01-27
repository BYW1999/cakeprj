package com.by.bycake.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.by.bycake.entity.Orderlist;
import com.by.bycake.util.BaseDao;

/*实现对订单表的增删改查*/

@Repository
public class OrderlistDaoImpl extends BaseDao {
	
	//返回所有的订单
	public List<Orderlist> findAllOrderlist(){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Orderlist");
		return q.list();
	}
	
	//将购物车蛋糕插入订单表（返回自增主键）
	public int addCakeIntoOrderlist(String usermail,String addr,String phone,int status) {
		Date d=new Date();
		java.sql.Date date = new java.sql.Date(d.getTime());
		final String sql = "insert into orderlist(usermail,ordertime,addr,phone,status) values(?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				//PreparedStatement pstm = conn.prepareStatement(sql);
				PreparedStatement pstm=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				pstm.setString(1, usermail);
				pstm.setDate(2, date);
				pstm.setString(3, addr);
				pstm.setString(4, phone);
				pstm.setInt(5, status);
				return pstm;
			}
		},keyHolder);
		System.out.println("【返回自增主键】："+keyHolder.getKey().intValue());
		return keyHolder.getKey().intValue();
	}
	
}

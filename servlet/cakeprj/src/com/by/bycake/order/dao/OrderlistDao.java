package com.by.bycake.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.by.bycake.entity.Cake;
import com.by.bycake.entity.Orderlist;
import com.by.bycake.entity.User;
import com.by.bycake.util.BaseDao;


/*
 * 实现对订单表的增删改查
 */


public class OrderlistDao {
	//返回所有的订单
	public List<Orderlist> findAllOrder(){
		List<Orderlist> list = new ArrayList<Orderlist>();
		Connection conn = BaseDao.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from orderlist");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Orderlist ol = new Orderlist();
				ol.setOrderid(rs.getInt("orderid"));
				ol.setUsermail(rs.getString("usermail"));
				ol.setOrdertime(rs.getString("ordertime"));
				ol.setAddr(rs.getString("addr"));
				ol.setStatus(rs.getInt("status"));
				list.add(ol);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	//将购物车蛋糕插入订单表
	public int addOrderlist(Orderlist orderlist) {
		
		//String usermail = user.getUsermail();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String ordertime=sdf.format(date);
		
		Connection conn = BaseDao.getConnection();
		String insertsql = "insert into orderlist(orderid,usermail,ordertime,addr,phone,status) values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(insertsql);
			pstm.setInt(1, orderlist.getOrderid());
			pstm.setString(2, orderlist.getUsermail());
			pstm.setString(3, ordertime);
			pstm.setString(4, orderlist.getAddr());
			pstm.setString(5, orderlist.getPhone());
			pstm.setInt(6, orderlist.getStatus());
			int count=pstm.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}

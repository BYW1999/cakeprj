package com.by.bycake.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.by.bycake.cake.service.CakeService;
import com.by.bycake.entity.Cake;
import com.by.bycake.entity.Orderlist;
import com.by.bycake.entity.Ordermanage;
import com.by.bycake.util.BaseDao;

/*
 * 实现对订单明细表的增删改查
 */
public class OrdermanageDao {
	
	//返回订单明细表的所有订单详情
	public List<Ordermanage> findAllOrdermanage(){
		List<Ordermanage> list = new ArrayList<Ordermanage>();
		Connection conn = BaseDao.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from ordermanage");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Ordermanage om = new Ordermanage();
				om.setOmid(rs.getInt("omid"));
				om.setOrderid(rs.getInt("orderid"));
				om.setCakeid(rs.getInt("cakeid"));
				om.setAmount(rs.getInt("amount"));
				list.add(om);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//返回订单明细表销量前八名的蛋糕列表
	public List<Cake> findTopOrderCake(){
		List<Cake> list = new ArrayList<Cake>();
		Connection conn = BaseDao.getConnection();
		String sql = "select cakeid,sum(amount) from ordermanage group by cakeid order by sum(amount) desc limit 0,8 ";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Cake c = new Cake();
				int cakeid = rs.getInt("cakeid");
				CakeService cs = new CakeService();
				c=cs.findCakeByCakeid(cakeid);
				list.add(c);	
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//将购物车蛋糕加入订单明细表
	public int addOrdermanager(Ordermanage ordermanage) {
		Connection conn = BaseDao.getConnection();
		String sql = "insert into ordermanage(omid,orderid,cakeid,amount) values(?,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ordermanage.getOmid());
			pstm.setInt(2, ordermanage.getOrderid());
			pstm.setInt(3, ordermanage.getCakeid());
			pstm.setInt(4, ordermanage.getAmount());
			int count = pstm.executeUpdate();
			return count;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}
}

package com.by.bycake.cake.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.by.bycake.entity.Cake;
import com.by.bycake.util.BaseDao;

import javafx.scene.control.ColorPicker;

/*
 * 实现对蛋糕表的增删改查
 */
public class CakeDao {
	public List<Cake> findAllCake(){
		List<Cake> list = new ArrayList<Cake>();
		Connection conn = BaseDao.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from cake");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cake c = new Cake();
				c.setCakeid(rs.getInt("cakeid"));
				c.setCakename(rs.getString("cakename"));
				c.setCakesize(rs.getInt("cakesize"));
				c.setCakeintroduce(rs.getString("cakeintroduce"));
				c.setCakeprice(rs.getInt("cakeprice"));
				c.setCakediscount(rs.getInt("cakediscount"));
				c.setBigpic(rs.getString("bigpic"));
				c.setSmapic1(rs.getString("smapic1"));
				c.setSmapic2(rs.getString("smapic2"));
				c.setSmapic3(rs.getString("smapic3"));
				c.setCakerate(rs.getInt("cakerate"));
				c.setTag(rs.getString("tag"));
				c.setTypeid(rs.getInt("typeid"));
				
				list.add(c);
			}
			System.out.println("蛋糕表连接成功");
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("蛋糕表连接失败");
			return null;
		}
	}
	
	/*
	 * 统计蛋糕个数
	 * 
	 */
	public int findCakeCount() {
		Connection conn = BaseDao.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement("select count(cakeid) from cake");
			ResultSet rs = pstm.executeQuery();
			int count = 0;
			while(rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	
	/*
	 * 分页查询技术
	 * pageNum 当前页码
	 * pageSize 一页显示的条数
	 */
	public List<Cake> findByPage(int pageNum,int pageSize){
		List<Cake> list = new ArrayList<Cake>();
		Connection conn = BaseDao.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement("select * from cake limit ?,?");
			pstm.setInt(1, (pageNum-1)*pageSize);
			pstm.setInt(2, pageSize);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Cake c = new Cake();
				c.setCakeid(rs.getInt("cakeid"));
				c.setCakename(rs.getString("cakename"));
				c.setCakesize(rs.getInt("cakesize"));
				c.setCakeintroduce(rs.getString("cakeintroduce"));
				c.setCakeprice(rs.getInt("cakeprice"));
				c.setCakediscount(rs.getInt("cakediscount"));
				c.setBigpic(rs.getString("bigpic"));
				c.setSmapic1(rs.getString("smapic1"));
				c.setSmapic2(rs.getString("smapic2"));
				c.setSmapic3(rs.getString("smapic3"));
				c.setCakerate(rs.getInt("cakerate"));
				c.setTag(rs.getString("tag"));
				c.setTypeid(rs.getInt("typeid"));
				list.add(c);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	/*
	 * 根据typeid查询蛋糕数量
	 */
	public int findCakeCountByTypeid(int typeid) {
		Connection conn = BaseDao.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement("select count(cakeid) from cake where typeid=?");
			pstm.setInt(1, typeid);
			ResultSet rs = pstm.executeQuery();
			int count = 0;
			while(rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	
	/*
	 * 根据typeid查询蛋糕列表
	 */
	public List<Cake> findCakeByTypeid(int typeid,int pageNum,int pageSize){
		List<Cake> list = new ArrayList<Cake>();
		Connection conn = BaseDao.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement("select * from cake where typeid=? limit ?,?");
			pstm.setInt(1, typeid);
			pstm.setInt(2, (pageNum-1)*pageSize);
			pstm.setInt(3, pageSize);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Cake c = new Cake();
				c.setCakeid(rs.getInt("cakeid"));
				c.setCakename(rs.getString("cakename"));
				c.setCakesize(rs.getInt("cakesize"));
				c.setCakeintroduce(rs.getString("cakeintroduce"));
				c.setCakeprice(rs.getInt("cakeprice"));
				c.setCakediscount(rs.getInt("cakediscount"));
				c.setBigpic(rs.getString("bigpic"));
				c.setSmapic1(rs.getString("smapic1"));
				c.setSmapic2(rs.getString("smapic2"));
				c.setSmapic3(rs.getString("smapic3"));
				c.setCakerate(rs.getInt("cakerate"));
				c.setTag(rs.getString("tag"));
				c.setTypeid(rs.getInt("typeid"));
				
				list.add(c);
			}
			System.out.println("蛋糕表连接成功");
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("蛋糕表连接失败");
			return null;
		}
	}
	
	/*
	 * 根据cakename查询蛋糕数量
	 */
	public int findCakeCountByCakename(String cakename) {
		Connection conn = BaseDao.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement("select count(cakeid) from cake where cakename=?");
			pstm.setString(1, cakename);
			ResultSet rs = pstm.executeQuery();
			int count = 0;
			while(rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	/*
	 * 根据cakename查询蛋糕列表
	 */
	public List<Cake> findCakeByCakename(String cakename,int pageNum,int pageSize){
		List<Cake> list = new ArrayList<Cake>();
		Connection conn = BaseDao.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement("select * from cake where cakename=? limit ?,?");
			pstm.setString(1, cakename);
			pstm.setInt(2, (pageNum-1)*pageSize);
			pstm.setInt(3, pageSize);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Cake c = new Cake();
				c.setCakeid(rs.getInt("cakeid"));
				c.setCakename(rs.getString("cakename"));
				c.setCakesize(rs.getInt("cakesize"));
				c.setCakeintroduce(rs.getString("cakeintroduce"));
				c.setCakeprice(rs.getInt("cakeprice"));
				c.setCakediscount(rs.getInt("cakediscount"));
				c.setBigpic(rs.getString("bigpic"));
				c.setSmapic1(rs.getString("smapic1"));
				c.setSmapic2(rs.getString("smapic2"));
				c.setSmapic3(rs.getString("smapic3"));
				c.setCakerate(rs.getInt("cakerate"));
				c.setTag(rs.getString("tag"));
				c.setTypeid(rs.getInt("typeid"));
				list.add(c);
			}
			System.out.println(list);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("蛋糕表连接失败(名字查找)");
			return null;
		}
	}
	
	//根据cakeid查找蛋糕
	public Cake findCakeByCakeid(int cakeid) {
		Connection conn = BaseDao.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement("select * from cake where cakeid=?");
			pstm.setInt(1, cakeid);
			ResultSet rs = pstm.executeQuery();
			Cake c = new Cake();
			while (rs.next()) {
				c.setCakeid(rs.getInt("cakeid"));
				c.setCakename(rs.getString("cakename"));
				c.setCakesize(rs.getInt("cakesize"));
				c.setCakeintroduce(rs.getString("cakeintroduce"));
				c.setCakeprice(rs.getInt("cakeprice"));
				c.setCakediscount(rs.getInt("cakediscount"));
				c.setBigpic(rs.getString("bigpic"));
				c.setSmapic1(rs.getString("smapic1"));
				c.setSmapic2(rs.getString("smapic2"));
				c.setSmapic3(rs.getString("smapic3"));
				c.setCakerate(rs.getInt("cakerate"));
				c.setTag(rs.getString("tag"));
				c.setTypeid(rs.getInt("typeid"));
			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}

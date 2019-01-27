package com.by.bycake.user.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.by.bycake.entity.User;
import com.by.bycake.util.BaseDao;

/**
 * 实现对用户表的增删改查
 *
 */

public class UserDaoImpl {
	//获取所有的用户
	public List<User> findAllUser(){
		List<User> list = new ArrayList<User>();
		Connection conn = BaseDao.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User u = new User();
				u.setUsermail(rs.getString("usermail"));
				u.setUsername(rs.getString("username"));
				u.setUserfaname(rs.getString("userfaname"));
				u.setPassword(rs.getString("password"));
				u.setRegistertime(rs.getString("registertime"));
				list.add(u);
				System.out.println(u);
			}
			System.out.println(list);
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("用户表连接错误");
			return null;
		}
	}
	
	//确认用户
	public User confirmLoginUser(String email){
		Connection conn = BaseDao.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from user where usermail=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User u = new User();
				u.setUsermail(rs.getString("usermail"));
				u.setUsername(rs.getString("username"));
				u.setUserfaname(rs.getString("userfaname"));
				u.setPassword(rs.getString("password"));
				u.setRegistertime(rs.getString("registertime"));
				System.out.println(u);
				return u;
			}
			System.out.println("没有这个用户");
			return null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("用户表连接错误");
			return null;
		}
	} 
	
	//插入新的用户
	public int InsertNewUser(User u) {
		Connection conn = BaseDao.getConnection();
		String username=u.getUsername();
		String userfaname=u.getUserfaname();
		String usermail=u.getUsermail();
		String password=u.getPassword();
		String registertime=u.getRegistertime();
		
		//String sql="insert into user"+"values("+usermail+username+userfaname+password+registertime+")";
		String sql ="insert into user values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usermail);
			ps.setString(2, username);
			ps.setString(3, userfaname);
			ps.setString(4, password);
			ps.setString(5, registertime);
			int count=ps.executeUpdate();
			System.out.println("插入成功！");
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("用户插入错误");
			return 0;
		}
	}
}

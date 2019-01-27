package com.by.bycake.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		String url = "jdbc:mysql://127.0.0.1:3306/cake?useUnicode=true&characterEncoding=UTF-8";
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, "root","");
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	//关闭数据库连接(偷懒了不能只关闭一个 )
	public static void closeCon(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}
}

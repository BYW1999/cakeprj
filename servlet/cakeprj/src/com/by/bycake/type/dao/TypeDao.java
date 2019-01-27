package com.by.bycake.type.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.by.bycake.entity.Type;
import com.by.bycake.util.BaseDao;

/*
 * 实现对蛋糕类型表的增删改查
 */

public class TypeDao {
	public List<Type> findAllType(){
		List<Type> list = new ArrayList<Type>();
		Connection conn = BaseDao.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from type");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Type t = new Type();
				t.setTypeid(rs.getInt("typeid"));
				t.setTypename(rs.getString("typename"));
				t.setFatypeid(rs.getInt("fatypeid"));
				list.add(t);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}

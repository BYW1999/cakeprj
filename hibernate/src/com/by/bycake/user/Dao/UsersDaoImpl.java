package com.by.bycake.user.Dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.by.bycake.entity.Users;
import com.by.bycake.util.BaseDao;
@Repository
public class UsersDaoImpl extends BaseDao {

	//获取所有的用户
	public List<Users> findAllUsers(){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Users");
		return q.list();
	}
	
	//确认用户
	public Users confirmUser(String email){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Users u where u.usermail=?");
		q.setString(0, email);
		Users users = (Users) q.uniqueResult();
		return users;
	} 
	
	//插入新的用户
	public void AddUser(String usermail,String username,String userfaname,String password) {
		Date d=new Date();
		java.sql.Date date = new java.sql.Date(d.getTime());
		String sql = "insert into user values(?,?,?,?,?)";
		this.jdbcTemplate.update(sql,usermail,username,userfaname,password,date);
		System.out.println("[插入user:usermail:"+usermail+"]");
	}
	
}

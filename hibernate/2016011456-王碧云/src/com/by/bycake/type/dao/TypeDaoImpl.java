package com.by.bycake.type.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.by.bycake.entity.CakeType;
import com.by.bycake.util.BaseDao;

/*
 * 实现对蛋糕类型表的增删改查
 */

@Repository
public class TypeDaoImpl extends BaseDao {
	
	public List<CakeType> findAllType(){
		Session session = this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from CakeType ct where ct.parentType is null");
		System.out.println("[type]:"+q.list());
		return q.list();
	}
	
}

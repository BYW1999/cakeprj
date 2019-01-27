package com.by.bycake.util;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {
	@Resource
	public SessionFactory sessionFactory;
	@Autowired
	public JdbcTemplate jdbcTemplate;
}

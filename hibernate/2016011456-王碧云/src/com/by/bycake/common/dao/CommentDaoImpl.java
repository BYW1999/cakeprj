package com.by.bycake.common.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.by.bycake.entity.Comment;
import com.by.bycake.util.BaseDao;
@Repository
public class CommentDaoImpl extends BaseDao {

	//根据cakeid返回相关评论
	public List<Comment> findCommentByCakeId(int cakeid){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Comment c where c.cakeid=?");
		q.setInteger(0, cakeid);
		return q.list();
	}
	
}

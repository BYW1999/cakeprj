package com.by.bycake.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.by.bycake.entity.Comment;
import com.by.bycake.util.BaseDao;

public class CommentDao {

	//根据cakeid返回相关评论
	public List<Comment> findCommentByCakeId(int cakeid){
		List<Comment> list = new ArrayList<Comment>();
		Connection conn = BaseDao.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement("select * from comment where cakeid=?");
			pstm.setInt(1, cakeid);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Comment c = new Comment();
				c.setCakeid(cakeid);
				c.setCommentid(rs.getInt("commentid"));
				c.setContent(rs.getString("content"));
				c.setCommenttime(rs.getString("commenttime"));
				c.setUsermail(rs.getString("usermail"));
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}

package com.by.bycake.common.service;

import java.util.List;

import com.by.bycake.common.dao.CommentDao;
import com.by.bycake.entity.Comment;

public class CommentService {

	//根据cakeid返回相关评论
	public List<Comment> findCommentByCakeId(int cakeid){
		CommentDao cd = new CommentDao();
		return cd.findCommentByCakeId(cakeid);
	}
}

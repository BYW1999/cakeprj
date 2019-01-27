package com.by.bycake.common.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.by.bycake.common.dao.CommentDaoImpl;
import com.by.bycake.entity.Comment;

@Service
@Transactional(readOnly=true)
public class CommentServiceImpl {

	@Resource
	private CommentDaoImpl commentDaoImpl;
	
	//根据cakeid返回相关评论
	public List<Comment> findCommentByCakeId(int cakeid){
		return this.commentDaoImpl.findCommentByCakeId(cakeid);
	}
}

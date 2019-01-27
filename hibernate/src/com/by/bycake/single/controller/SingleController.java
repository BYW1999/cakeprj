package com.by.bycake.single.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.by.bycake.cake.service.CakeServiceImpl;
import com.by.bycake.common.service.CommentServiceImpl;
import com.by.bycake.entity.Cake;
import com.by.bycake.entity.Comment;

@Controller
public class SingleController {

	@Resource
	private CakeServiceImpl cakeServiceImpl;
	@Resource
	private CommentServiceImpl commentServiceImpl;
	/*
	 * cakeid 商品id
	 */
	@RequestMapping("/singleController")
	public String singleController(@RequestParam("cakeid") String cakeid,HttpServletRequest request,HttpServletResponse response) {
		//根据商品id返回商品
		Cake cake = this.cakeServiceImpl.findCakeByCakeid(Integer.parseInt(cakeid));
		
		//根据商品id返回评论
		List<Comment> commentlist = this.commentServiceImpl.findCommentByCakeId(Integer.parseInt(cakeid));
		
		request.setAttribute("commentlist", commentlist);
		request.setAttribute("singlecake", cake);
		
		return "single";
	}
	
}

package com.by.bycake.entity;

public class Comment {
	private int commentid;
	private String content;
	private String commenttime;
	private int cakeid;
	private String usermail;
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommenttime() {
		return commenttime;
	}
	public void setCommenttime(String commenttime) {
		this.commenttime = commenttime;
	}
	public int getCakeid() {
		return cakeid;
	}
	public void setCakeid(int cakeid) {
		this.cakeid = cakeid;
	}
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	@Override
	public String toString() {
		return "Comment [commentid=" + commentid + ", content=" + content + ", commenttime=" + commenttime + ", cakeid="
				+ cakeid + ", usermail=" + usermail + "]";
	}
	
	
	
}

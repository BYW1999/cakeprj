package com.by.bycake.entity;

import java.util.List;

public class Page<T> {
	
	
	private List<T> list;
	private int currentPageNum;//当前的页面数
	private int pageSize;	//一个页面显示的条数
	private int prePageNum;	//前一页
	private int nextPageNum;	//后一页
	private int totalPageNum;	//页面的页数
	private int totalCount;	//数据库总的条数
	
	public Page(){
		
	}
	
	public Page(int pageNum,int pageSize){
		this.currentPageNum = pageNum;
		this.pageSize = pageSize;
	}
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPrePageNum() {
		return prePageNum;
	}
	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}
	public int getNextPageNum() {
		return nextPageNum;
	}
	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;	//蛋糕总条数
		if(totalCount%pageSize == 0) {
			totalPageNum = totalCount/pageSize;
		}else {
			totalPageNum = totalCount/pageSize+1;
		}
		if(currentPageNum > 1) {
			prePageNum = currentPageNum - 1; 
		}else {
			prePageNum = 1;
		}
		if(currentPageNum < totalPageNum) {
			nextPageNum = currentPageNum + 1;
		}else {
			nextPageNum = totalPageNum;
		}
	}
	@Override
	public String toString() {
		return "Page [list=" + list + ", currentPageNum=" + currentPageNum + ", pageSize=" + pageSize + ", prePageNum="
				+ prePageNum + ", nextPageNum=" + nextPageNum + ", totalPageNum=" + totalPageNum + ", totalCount="
				+ totalCount + "]";
	}
	
	
}

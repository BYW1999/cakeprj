package com.by.bycake.cake.service;

import java.util.List;

import com.by.bycake.cake.dao.CakeDao;
import com.by.bycake.entity.Cake;

public class CakeService {
	
	//返回所有的蛋糕列表
	public List<Cake> findAllCakeList(){
		CakeDao cd = new CakeDao();
		return cd.findAllCake();
	}
	
	//返回蛋糕个数
	public int findCakeCount() {
		CakeDao cd = new CakeDao();
		return cd.findCakeCount();
	}
	
	//根据页码条数返回对应的蛋糕（分页查询技术）
	public List<Cake> findByPage(int pageNum,int pageSize){
		CakeDao cd = new CakeDao();
		return cd.findByPage(pageNum,pageSize);
	}
	
	//根据typeid返回蛋糕数量
	public int findCakeCountByTypeid(int typeid) {
		CakeDao cd = new CakeDao();
		return cd.findCakeCountByTypeid(typeid);
	}
	
	//根据typeid返回对应的蛋糕
	public List<Cake> findCakeByTypeid(int typeid,int pageNum,int pageSize){
		CakeDao cd = new CakeDao();
		return cd.findCakeByTypeid(typeid,pageNum,pageSize);
	}
	
	//根据cakename返回蛋糕数量
	public int findCakeCountByCakename(String cakename) {
		CakeDao cd = new CakeDao();
		return cd.findCakeCountByCakename(cakename);
	}
	
	//根据cakename返回相应的蛋糕
	public List<Cake> findCakeByCakename(String cakename,int pageNum,int pageSize){
		CakeDao cd = new CakeDao();
		return cd.findCakeByCakename(cakename, pageNum, pageSize);
	}
	
	//根据cakeid返回蛋糕
	public Cake findCakeByCakeid(int cakeid) {
		CakeDao cd = new CakeDao();
		return cd.findCakeByCakeid(cakeid);
	}
}

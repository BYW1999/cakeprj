package com.by.bycake.cake.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.by.bycake.cake.dao.CakeDaoImpl;
import com.by.bycake.entity.Cake;

@Service
@Transactional(readOnly=true)
public class CakeServiceImpl {

	@Resource
	private CakeDaoImpl cakeDaoImpl;
	
	//查找全部蛋糕
	public List<Cake> findAllCake(){
		return this.cakeDaoImpl.findAllCake();
	}
	
	//根据cakeid查找蛋糕
	public Cake findCakeByCakeid(int cakeid) {
		return this.cakeDaoImpl.findCakeByCakeid(cakeid);
	}
	//返回订单明细表销量前八名的蛋糕列表
	public List<Cake> findTopOrderCake(){
		return this.cakeDaoImpl.findTopOrderCake();
	}
	/*
	 * 分页查询技术
	 * pageNum 当前页码
	 * pageSize 一页显示的条数
	 */
	public List<Cake> findByPage(int pageNum,int pageSize){
		return this.cakeDaoImpl.findByPage(pageNum, pageSize);
	}
	//统计蛋糕个数
	public int findCakeCount() {
		return this.cakeDaoImpl.findCakeCount();
	}
	
	//根据typeid查询蛋糕数量
	public int findCakeCountByTypeid(int typeid) {
		return this.cakeDaoImpl.findCakeCountByTypeid(typeid);
	}
	//根据typeid查询蛋糕列表(选出对应页码的蛋糕条数)
	public List<Cake> findCakeByTypeid(int typeid,int pageNum,int pageSize){
		return this.cakeDaoImpl.findCakeByTypeid(typeid, pageNum, pageSize);
	}
	//根据cakename查询蛋糕数量
	public int findCakeCountByCakename(String cakename) {
		return this.cakeDaoImpl.findCakeCountByCakename(cakename);
	}
	/*
	 * 根据cakename查询蛋糕列表
	 */
	public List<Cake> findCakeByCakename(String cakename,int pageNum,int pageSize){
		return this.cakeDaoImpl.findCakeByCakename(cakename, pageNum, pageSize);
	}
}

package com.by.bycake.products.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.by.bycake.cake.service.CakeServiceImpl;
import com.by.bycake.entity.Cake;
import com.by.bycake.entity.Page;

@Service
@Transactional(readOnly=true)
public class ProductsServiceImpl {

	@Resource
	private CakeServiceImpl cakeServiceImpl;
	
	public Page<Cake> checkCake(String typeid,String pageNum,String cakename){	
		int num = 0;
		if(pageNum==null || pageNum.equals("")) {
			num = 1;
		}else {
			num = Integer.parseInt(pageNum);
		}
		Page<Cake> p = new Page<Cake>(num,6);		//创建Page对象p进行分页
		int count = 0;
		List<Cake> list = null;
		if(typeid != null && !"".equals(typeid)) {	//存在typeid查找 
			count = this.cakeServiceImpl.findCakeCountByTypeid(Integer.parseInt(typeid));			//获得蛋糕数量
			list = this.cakeServiceImpl.findCakeByTypeid(Integer.parseInt(typeid), num, 6);	//获得分页的蛋糕
		}else if(cakename != null && !"".equals(cakename)) {	//存在cakename查找    
			count = this.cakeServiceImpl.findCakeCountByCakename(cakename);
			list = this.cakeServiceImpl.findCakeByCakename(cakename, num, 6);
		}else {		
			count = this.cakeServiceImpl.findCakeCount();
			list = this.cakeServiceImpl.findByPage(num, 6);
		}
		p.setList(list); 						//设置p列表的蛋糕
		p.setTotalCount(count);					//设置p的蛋糕数量
		return p;
	}
}

package com.by.bycake.type.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.by.bycake.entity.CakeType;
import com.by.bycake.type.dao.TypeDaoImpl;

@Service
@Transactional(readOnly=true)
public class TypeServiceImpl {
	@Resource
	private TypeDaoImpl typeDaoImpl;
	
	public List<CakeType> listType(){
		return this.typeDaoImpl.findAllType();
	}
}

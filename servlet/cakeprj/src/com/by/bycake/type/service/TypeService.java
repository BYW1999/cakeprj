package com.by.bycake.type.service;

import java.util.List;

import com.by.bycake.entity.Type;
import com.by.bycake.type.dao.TypeDao;

public class TypeService {
	
	public List<Type> listType(){
		TypeDao td = new TypeDao();
		return td.findAllType();
	}
	
}

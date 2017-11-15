package com.rdyang.mall.manager.service.impl;

import java.util.Map;

import com.rdyang.hibernate.dao.BaseDao;
import com.rdyang.hibernate.util.Pagination;
import com.rdyang.mall.manager.service.BaseService;
import com.rdyang.springmvc.base.SpringContextHolder;

public abstract class BaseServiceImpl implements BaseService {
	
	private BaseDao baseDao;
	@Override
	public Pagination<?> find(Integer pageIndex, Integer pageSize,
			Map<String, Object> params) {
		baseDao = (BaseDao) SpringContextHolder.getBean("stockDao");
		Pagination<?> findPagination = baseDao.findPagination(pageIndex, pageSize, params);
		return findPagination;
	}
}

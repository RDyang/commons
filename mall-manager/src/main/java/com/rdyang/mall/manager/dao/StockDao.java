package com.rdyang.mall.manager.dao;

import java.util.List;
import java.util.Map;

import com.rdyang.hibernate.dao.BaseDao;
import com.rdyang.hibernate.util.Pagination;
import com.rdyang.mall.manager.entity.Stock;

public interface StockDao extends BaseDao<Stock, Integer>{

	List<Stock> getAllStore();
	
	Pagination<Stock> findStock(int pageIndex, int pageSize, Map<String, Object> params);
}

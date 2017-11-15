package com.rdyang.mall.manager.service;

import java.util.Map;

import com.rdyang.hibernate.util.Pagination;
import com.rdyang.mall.manager.entity.Stock;

public interface StockService extends BaseService{
	Pagination<Stock> findStock(int pageIndex, int pageSize, Map<String, Object> params);
}

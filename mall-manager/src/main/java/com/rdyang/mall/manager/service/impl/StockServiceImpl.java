package com.rdyang.mall.manager.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdyang.hibernate.util.Pagination;
import com.rdyang.mall.manager.dao.StockDao;
import com.rdyang.mall.manager.entity.Stock;
import com.rdyang.mall.manager.service.StockService;

@Service("stockService")
public class StockServiceImpl extends BaseServiceImpl implements StockService {

	private static Logger log = LoggerFactory.getLogger(StockServiceImpl.class);

	@Autowired
	private StockDao stockDao;
	@Override
	public Pagination<Stock> findStock(int pageIndex, int pageSize,
			Map<String, Object> params) {
		log.info("service: params=" + params.toString() + " pageIndex="
				+ pageIndex + " pageSize=" + pageSize);
		Pagination<Stock> findStock = stockDao.findPagination(pageIndex, pageSize,
				params);
		return findStock;
	}
	
}

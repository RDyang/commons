package com.rdyang.mall.manager.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rdyang.hibernate.dao.impl.BaseDaoImpl;
import com.rdyang.hibernate.util.Pagination;
import com.rdyang.mall.manager.dao.StockDao;
import com.rdyang.mall.manager.entity.Stock;

@Repository("stockDao")
public class StockDaoImpl extends BaseDaoImpl<Stock, Integer>
		implements
			StockDao {

	@Override
	public List<Stock> getAllStore() {

		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Pagination<Stock> findStock(int pageIndex, int pageSize,
			Map<String, Object> params) {
		XqlHelper xqlHelper = new XqlHelper();
		String hql = xqlHelper.createHql(params);
		List<Stock> find = find(hql, pageIndex, pageSize, params);
		long rowsCount = getRowsCount(params);
		Pagination<Stock> stock = new Pagination<>(rowsCount, pageIndex,
				pageSize, find.size(), find);
		return stock;
	}

}

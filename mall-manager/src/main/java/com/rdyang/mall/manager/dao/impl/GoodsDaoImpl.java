package com.rdyang.mall.manager.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rdyang.hibernate.dao.impl.BaseDaoImpl;
import com.rdyang.hibernate.util.Pagination;
import com.rdyang.mall.manager.dao.GoodsDao;
import com.rdyang.mall.manager.entity.Goods;

@Repository
public class GoodsDaoImpl extends BaseDaoImpl<Goods, Integer>
		implements
			GoodsDao {

	@SuppressWarnings("deprecation")
	@Override
	public Pagination<Goods> findGoods(Integer pageIndex, Integer pageSize,
			Map<String, Object> params) {
		XqlHelper xqlHelper = new XqlHelper();
		String hql = xqlHelper.createHql(params);
		List<Goods> find = find(hql, pageIndex, pageSize, params);
		long rowsCount = getRowsCount(params);
		Pagination<Goods> page = new Pagination<>(rowsCount, pageIndex,
				pageSize, find.size(), find);
		return page;
	}

}

package com.rdyang.mall.manager.dao;

import java.util.Map;

import com.rdyang.hibernate.dao.BaseDao;
import com.rdyang.hibernate.util.Pagination;
import com.rdyang.mall.manager.entity.Goods;

public interface GoodsDao extends BaseDao<Goods, Integer> {
	Pagination<Goods> findGoods(Integer pageIndex, Integer pageSize,Map<String,Object> params);
}

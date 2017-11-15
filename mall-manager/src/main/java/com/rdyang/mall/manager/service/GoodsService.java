package com.rdyang.mall.manager.service;

import java.util.Map;

import com.rdyang.hibernate.util.Pagination;
import com.rdyang.mall.manager.entity.Goods;

public interface GoodsService extends BaseService{
	Pagination<Goods> findGoods(Integer pageIndex, Integer pageSize,
			Map<String, Object> params);
}

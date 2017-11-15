package com.rdyang.mall.manager.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdyang.hibernate.util.Pagination;
import com.rdyang.mall.manager.dao.GoodsDao;
import com.rdyang.mall.manager.entity.Goods;
import com.rdyang.mall.manager.service.GoodsService;

@Service
public class GoodsServiceImpl extends BaseServiceImpl implements GoodsService{

	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public Pagination<Goods> findGoods(Integer pageIndex, Integer pageSize,
			Map<String, Object> params) {
		Pagination<Goods> find = goodsDao.findPagination(pageIndex, pageSize, params);
		return find;
	}
	
}

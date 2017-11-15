package com.rdyang.mall.manager.service;

import java.util.Map;

import com.rdyang.hibernate.util.Pagination;

public interface BaseService {
	Pagination<?> find(Integer pageIndex, Integer pageSize,
			Map<String, Object> params);
}

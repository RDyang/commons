package com.rdyang.mall.manager.service;

import java.util.List;

import com.rdyang.mall.manager.entity.Menu;

public interface MenuService extends BaseService {

	/**
	 * 根据父id查询菜单
	 * @param parentId Integer
	 * @return List
	 */
	public List<Menu> findMenuByParentId(Integer parentId);
}

package com.rdyang.mall.manager.dao;

import java.util.List;

import com.rdyang.hibernate.dao.BaseDao;
import com.rdyang.mall.manager.entity.Menu;

public interface MenuDao extends BaseDao<Menu,Integer> {
	
	/**
	 * 根据父id查找菜单项
	 * @param parentId
	 * @return
	 */
	List<Menu> findMenuByParentId(Integer parentId);
}

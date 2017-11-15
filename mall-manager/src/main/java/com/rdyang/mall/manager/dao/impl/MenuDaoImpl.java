package com.rdyang.mall.manager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rdyang.hibernate.dao.impl.BaseDaoImpl;
import com.rdyang.mall.manager.dao.MenuDao;
import com.rdyang.mall.manager.entity.Menu;

@Repository
public class MenuDaoImpl extends BaseDaoImpl<Menu,Integer> implements MenuDao {
	
	@SuppressWarnings("deprecation")
	@Override
	public List<Menu> findMenuByParentId(Integer parentId) {
		String hql = "from Menu where parentId = ?";
		List<Menu> find = find(hql, 0, 0, parentId);
		return (List<Menu>) find;
	}
}

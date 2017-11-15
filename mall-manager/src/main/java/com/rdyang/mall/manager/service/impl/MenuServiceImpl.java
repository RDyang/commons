package com.rdyang.mall.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdyang.mall.manager.dao.MenuDao;
import com.rdyang.mall.manager.entity.Menu;
import com.rdyang.mall.manager.service.MenuService;

@Service
public class MenuServiceImpl extends BaseServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;
	
	public List<Menu> findMenuByParentId(Integer parentId){
		List<Menu> menus = menuDao.findMenuByParentId(parentId);
		if(null == menus){
			return new ArrayList<>();
		}
		return menus;
	}
}

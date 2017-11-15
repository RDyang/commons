package com.rdyang.mall.manager.dao.menu.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rdyang.mall.manager.dao.MenuDao;
import com.rdyang.mall.manager.entity.Menu;
import com.rdyang.mall.manager.service.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
@Transactional
public class MenuDaoTest {
	
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private MenuService menuService;
	
//	@Autowired
//	private AdminDao adminDao;
	
	@Test
	public void testFindByParentId(){
		Integer i = new Integer(0);
		List<Menu> findMenuByParentId = menuDao.findMenuByParentId(i);
		System.out.println("666...");
	}
	
//	@Test
//	public void testFindAdminById(){
//		Admin findByAdminId = adminDao.findByAdminId("aaa");
//		System.out.println("66..");
//	}

}

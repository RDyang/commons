package com.rdyang.mall.manager.dao.menu.test;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rdyang.hibernate.util.Pagination;
import com.rdyang.mall.manager.dao.StockDao;
import com.rdyang.mall.manager.entity.Stock;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
@Transactional
public class StockDaoTest {

	@Autowired
	private StockDao stockDao;
	
	@Test
	public void testFindStock() {
		Pagination<Stock> findStock = stockDao.findStock(0, 0, new HashMap<>());
		System.out.println(findStock);
	}
}

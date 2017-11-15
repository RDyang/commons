package com.rdyang.hibernate.test;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rdyang.hibernate.test.entity.TestEntity;
import com.rdyang.hibernate.util.Pagination;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
@Transactional
public class PaginationTest {

	@Autowired
	private TestDao testDao;
	
	@Test
	public void testPager() {
		List<TestEntity> all = testDao.getAll();
		long rowsCount = testDao.getRowsCount(new HashMap<String, Object>());
		Pagination<TestEntity> page = new Pagination<>(rowsCount, 1,1, all.size(), all);
		System.out.println(page);
	}
}

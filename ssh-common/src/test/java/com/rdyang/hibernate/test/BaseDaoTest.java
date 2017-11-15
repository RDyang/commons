package com.rdyang.hibernate.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.rdyang.hibernate.test.entity.TestEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")

@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
@Transactional
public class BaseDaoTest {
	
	@Autowired
	private TestDao testDao;
	
	@Test
	@Rollback(false)
	public void save() {
		TestEntity te = new TestEntity();
		te.setName("fff");
		testDao.save(te);
	}
	
	@Test
	@Rollback(false)
	public void update() {
		TestEntity te = new TestEntity();
		te.setId(2);
		te.setName("d");
		testDao.update(te);
	}
	
	@Test
	public void testFind() {
		String queryString = "from TestEntity where id = ?";
		Map<String, Object> params = new HashMap<>();
		params.put("id", 0);
		List<TestEntity> find = testDao.find(queryString, 0, 0, params);
		for (TestEntity testEntity : find) {
			System.out.println(testEntity.toString());
		}
	}
	
	/**
	 * 测试hql以占位符方式传值的方法
	 * 无参数测试
	 * 一个参数测试
	 * 两个参数测试
	 */
	@Test
	public void testFind1() {
		StringBuilder hql = new StringBuilder("from TestEntity");
		//无参数测试
		List<TestEntity> find = testDao.find(hql, 0, 0);
		
		//一个参数测试
		hql.append(" where id = ?");
		List<TestEntity> find2 = testDao.find(hql, 0, 0, 0);
		
		hql.append(" and name = ?");
		List<TestEntity> find3 = testDao.find(hql, 0, 0, 1,"aaa");
		
		System.out.println(find);
		System.out.println(find2);
		System.out.println(find3);
		
	}
	
	@Test
	public void testGetAll() {
		List<TestEntity> all = testDao.getAll();
		System.out.println(all);
	}
	
	@Test
	@Rollback(false)
	public void saveOrUpdate() {
		TestEntity te = new TestEntity();
		te.setName("aaa");
		testDao.saveOrUpdate(te);
	}
	
	@Test
	@Rollback(false)
	public void saveOrUpdate1() {
		TestEntity testEntity = testDao.get(3);
		testEntity.setName("ff");
		testDao.saveOrUpdate(testEntity);
	}
	
	@Test
	public void testGetRowsCount() {
		long rowsCount = testDao.getRowsCount(new HashMap<>());
		System.out.println(rowsCount);
	}
	
}

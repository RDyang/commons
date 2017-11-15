package com.rdyang.springmvc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rdyang.springmvc.base.SpringContextHolder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
public class SpringContextHolderTest {
	
	public static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);
	
	@Test
	public void testGetBeanByName() {
		logger.info("bbb");
		Object bean = SpringContextHolder.getBean("dataSource");
		System.out.println(bean);
	}
	
	@Test
	public void testGetBeanByClass() {
		LocalSessionFactoryBean bean = SpringContextHolder.getBean(LocalSessionFactoryBean.class);
		System.out.println("aaa" + bean);
	}
	
	@Test
	public void testA() {
		System.out.println("-------------------");
		System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
		System.out.println("----------------------");
	}
}

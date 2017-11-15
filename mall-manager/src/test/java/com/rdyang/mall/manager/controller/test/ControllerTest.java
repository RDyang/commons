package com.rdyang.mall.manager.controller.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rdyang.springmvc.base.SpringContextHolder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class ControllerTest {

	@Test
	public void test() throws Exception {
//		Object bean = SpringContextHolder.getBean("stockService");
//		ApplicationContext type = SpringContextHolder.getApplicationContext();
//		System.out.println(type.getDeclaredAnnotations().length);
//		ParameterizedType type = (ParameterizedType)bean.getClass().getGenericSuperclass();
//		Class clazz = (Class)type.getActualTypeArguments()[0];
//		System.out.println(((FactoryBean<?>)bean).getObjectType());
//		System.out.println(clazz);
//		Pagination<?> find = bean.find(0, 10, new HashMap<>());
//		System.out.println(find.toString());
//		System.out.println(bean);
	}
	
	@Test
	public void testXML() {
		ApplicationContext applicationContext = SpringContextHolder.getApplicationContext();
	}
}

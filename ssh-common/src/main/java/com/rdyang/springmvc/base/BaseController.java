package com.rdyang.springmvc.base;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {
	
	public static Logger log = LoggerFactory.getLogger(BaseController.class);
	
	protected int pageIndex = 11;
	
	protected int pageSize = 5;
	
	public <T> Map<String, Object> setConditions(T t){
		Map<String, Object> params = new HashMap<>();
		Field[] fields = t.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				if(field.get(t) != null) {
					params.put(field.getName(), field.get(t));
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		log.info(params.toString());
		return params;
	}
	
	public Object getService(String name) {
		return SpringContextHolder.getBean(name);
	}
	
	public <T> T getService(Class<T> clazz) {
		return SpringContextHolder.getBean(clazz);
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}

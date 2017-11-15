package com.rdyang.springmvc.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHolder implements ApplicationContextAware {

	public static final Logger logger = LoggerFactory
			.getLogger(SpringContextHolder.class);

	private static Map<String, Class<?>> service = new HashMap<>();

	private static ApplicationContext applicationContext;
	@SuppressWarnings("static-access")
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		logger.info("setApplicationContext and init xmlUrl");
		this.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}

	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		return (T) applicationContext.getBean(clazz);
	}

	public static Object getBean(String name) {
		checkApplicationContext();
		return applicationContext.getBean(name);
	}

	public static void clear() {
		applicationContext = null;
	}

	private static void checkApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException(
					"applicationContext未注入，请在applicationContext.xml中定义SpringContextHolder。");
		}
	}

	/**
	 * 读取xml配置文件，本意将做service配套.
	 * 将service注解名和对应的类进行配套，以消除无用的Object对象。 
	 * 失败的尝试...
	 * 若启用，需在setApplicationContext()方法中调用初始化方法init()
	 * 并在用到该jar包的项目resource下创建service-mating.xml文件。
	 * 
	 * @author Administrator
	 * @deprecated
	 */
	static class XMLReader {

		private static String xmlUrl = "";
		public static void init() {
			try {
				xmlUrl = Thread.currentThread().getContextClassLoader()
						.getResource("service-mating.xml").getPath();
			} catch (Exception e) {
				logger.error("we must need a configuration file path.", e);
				throw e;
			}
			read();
		}
		public static void read() {
			File file = new File(xmlUrl);
			InputStream in;
			try {
				in = new FileInputStream(file);
				Properties prop = new Properties();
				prop.loadFromXML(in);
				for (Entry<Object, Object> entry : prop.entrySet()) {
					Class<?> clazz = Class.forName(entry.getValue().toString());
					service.put(entry.getKey().toString(), clazz);
				}
			} catch (FileNotFoundException e) {
				logger.error("read xml file error.", e);
			} catch (InvalidPropertiesFormatException e) {
				logger.error("format properties error.", e);
			} catch (IOException e) {
				logger.error("emmm...I don't know what happened.", e);
			} catch (ClassNotFoundException e) {
				logger.error("don't have this class.", e);
			}
		}
	}

}

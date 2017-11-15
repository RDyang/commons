package com.rdyang.log.test;

import org.junit.Test;
import org.slf4j.Logger;

import com.rdyang.log.config.Log;
import com.rdyang.log.factory.LogFactory;

public class LogTest {
	
	private Log logger = LogFactory.getLogger();
	
	private Log logger1 = LogFactory.getLogger("aaa");
	
	private Log logger2 = LogFactory.getLogger("bbb");
	
	private Log logger3 = LogFactory.getLogger4FullPath(this.getClass(), "E:\\logs\\test.log");
	
	private Log logger4 = LogFactory.getLogger4FullPath("E:\\loga\\test.log");
	
	
	@Test
	public void logTest(){
		logger.info("aa");
		logger1.info("bb");
		logger2.error("ccc", null);
		logger3.info("fullPath");
		logger4.info("test");
	}
	
}

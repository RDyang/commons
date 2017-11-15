package com.rdyang.log.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class ConfigCreation {
	
	private static final String CONFIG_PREFIX = "log4j.appender.";
	
	public static final String BASE_LOG_FILE_NAME = "core";
	
	private static final String LOG_FILE_SUFFIX = ".log";
	
	private static Properties props = null;
	
	private static String baseDir = "";
	
	private static String baseLogTitle = "";
	
	/**
	 * 初始化props、baseLogTitle、baseDir
	 * baseLogTitle:log4j.logger.core值，若为空，默认为"DEBUG"
	 * baseDir:log4j.appender.core.File值，不包括文件名。
	 * 若未空，默认为System.getProperty("user.dir")
	 */
	static{
		InputStream is = ConfigCreation.class.getClassLoader().getResourceAsStream("log4j.properties");
		props = new Properties();
		try {
			props.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(props.getProperty("log4j.logger.core") != null && !"null".equals(props.getProperty("log4j.logger.core")) && !"".equals(props.getProperty("log4j.logger.core").trim())){
			baseLogTitle = props.getProperty("log4j.logger.core");
		}else{
			baseLogTitle = "DEBUG";
		}
		if(props.getProperty("log4j.logger.core.File") != null && !"null".equals(props.getProperty("log4j.logger.core.File")) && !"".equals(props.getProperty("log4j.logger.core.File").trim())){
			baseDir = props.getProperty("log4j.logger.core.File");
		}else{
			baseDir = System.getProperty("user.dir") + "\\logs\\";
		}
	}
	
	
	/**
	 * 基础配置，日志文件名为core
	 */
	public static String configureBaseConfig(){
		return configureConfig4FileName(BASE_LOG_FILE_NAME);
	}
	
	public static String configure4ClassName(Class clazz){
		return configureConfig4FileName(clazz.getName());
	}
	
	/**
	 * 日志文件全路径配置
	 * @param fullPath
	 */
	public static void configureConfig4FullPath(String name, String fullPath){
		configureConfig(name, fullPath);
	}
	
	/**
	 * 只配置日志文件名。
	 * @param fileName
	 */
	public static String configureConfig4FileName(String fileName){
		String path = baseDir + fileName + LOG_FILE_SUFFIX;
		configureConfig(fileName,path);
		return path;
	}
	
	/**
	 * 配置log4j配置文件
	 * @param name 日志文件名
	 * @param path 日志路径
	 */
	private static void configureConfig(String name, String path){
			configureProperty(name, path);
			PropertyConfigurator.configure(props);
	}
	
	
	/**
	 * 装配log4j配置文件
	 * @param props
	 * @param name
	 * @param path
	 */
	private static void configureProperty(String name,String path){
		props.setProperty("log4j.logger." + name, baseLogTitle + "," + name);
		props.setProperty(CONFIG_PREFIX + name, 
				props.getProperty("log4j.appender.core"));
		props.setProperty(CONFIG_PREFIX + name + ".File", path);
		props.setProperty(CONFIG_PREFIX + name + ".layout", 
				props.getProperty("log4j.appender.core.layout"));
		props.setProperty(CONFIG_PREFIX + name + ".layout.ConversionPattern", 
				props.getProperty("log4j.appender.core.layout.ConversionPattern"));
	}
}

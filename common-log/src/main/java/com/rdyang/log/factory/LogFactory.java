package com.rdyang.log.factory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.rdyang.log.config.ConfigCreation;
import com.rdyang.log.config.Log;

public class LogFactory {
	
	private static Map<String,File> fileMap = new HashMap<>();
	
	
	/**
	 * 获取默认logger
	 * @return
	 */
	public static Log getLogger(){
		String configureBaseConfig = ConfigCreation.configureBaseConfig();
		Log log = new Log(ConfigCreation.BASE_LOG_FILE_NAME, configureBaseConfig);
		fileMap.put(ConfigCreation.BASE_LOG_FILE_NAME, new File(configureBaseConfig));
		return log;
	}
	
	/**
	 * 获取默认logger
	 * @param clazz
	 * @return
	 */
	public static Log getLogger(Class clazz){
		String configureBaseConfig = ConfigCreation.configure4ClassName(clazz);
		Log log = new Log(clazz, configureBaseConfig);
		fileMap.put(clazz.getName(), new File(configureBaseConfig));
		return log;
	}
	
	/**
	 * 自定义日志文件名的logger
	 * @param clazz
	 * @param file
	 * @return
	 */
	public static Log getLogger(String file){
		String configureConfig4FileName = ConfigCreation.configureConfig4FileName(file);
		Log log = new Log(file, configureConfig4FileName);
		fileMap.put(file, new File(configureConfig4FileName));
		return log;
		
	}
	
	/**
	 * 日志文件全路径配置，日志表示与日志名相同。
	 * @param fullPath
	 * @return
	 */
	public static Log getLogger4FullPath(String fullPath){
		String fullName = "";
		String[] catalog = {};
		if(fullName.contains("/")){
			catalog = fullPath.split("/");
		}else{
			catalog = fullPath.split("\\\\");
		}
		fullName = catalog[catalog.length - 1];
		String name = fullName.split("\\.")[0];
		Log log = getLogger4FullPath(name, fullPath);
		return log;
	}
	
	
	/**
	 * 设置全路径的日志文件，日志标记为clazz.getName()
	 * @param name
	 * @param fullPath
	 * @return
	 */
	public static Log getLogger4FullPath(Class clazz, String fullPath){
		ConfigCreation.configureConfig4FullPath(clazz.getName(), fullPath);
		Log log = new Log(clazz, fullPath);
		fileMap.put(clazz.getName(), new File(fullPath));
		return log;
	}
	
	/**
	 * 设置全路径的日志文件，日志标记为name
	 * @param name
	 * @param fullPath
	 * @return
	 */
	public static Log getLogger4FullPath(String name, String fullPath){
		ConfigCreation.configureConfig4FullPath(name, fullPath);
		Log log = new Log(name,fullPath);
		fileMap.put(name, new File(fullPath));
		return log;
	}

	public static Map<String, File> getFileMap() {
		return fileMap;
	}

}

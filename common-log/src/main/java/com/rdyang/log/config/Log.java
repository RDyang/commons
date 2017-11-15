package com.rdyang.log.config;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
	private Logger logger;
	private File logFile;

	public Log(String name, String logFile) {
		logger = LoggerFactory.getLogger(name);
		this.logFile = new File(logFile);
	}

	public Log(Class clazz, String logFile) {
		logger = LoggerFactory.getLogger(clazz);
		this.logFile = new File(logFile);
	}

	public void getLock() {
		
	}

	public void info(String msg) {
		synchronized (logFile) {
			logger.info(msg);
		}
	}

	public void debug(String msg) {
		synchronized (logFile) {
			logger.debug(msg);
		}
	}

	public void wran(String msg) {
		synchronized (logFile) {
			logger.warn(msg);
		}
	}

	public void error(String msg, Throwable t) {
		synchronized (logFile) {
			logger.error(msg, t);
		}
	}

	public File getLogFile() {
		return logFile;
	}

}

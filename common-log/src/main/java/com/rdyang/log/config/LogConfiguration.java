package com.rdyang.log.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public enum LogConfiguration {

	PREFIX("log4j.appender."),

	PREFIX_LOGGER("log4j.logger."),

	SUFFIX_FILE(".File"),

	SUFFIX_LAYOUT(".layout"),

	SUFFIX_LAYOUT_CONVERSION_PATTERN(".layout.ConversionPattern"),

	SUFFIX_FILE_VALUE("");

	private LogConfiguration(String value) {
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream("log4j.properties");
		Properties props = new Properties();
		try {
			props.load(is);
			Map<String, String> allProperties = getAllProperties(props);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Map<String, String> getAllProperties(Properties props) {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<?> en = props.propertyNames();
		String key = "";
		String value = "";
		while (en.hasMoreElements()) {
			key = (String) en.nextElement();
			value = props.getProperty(key);
			map.put(key, value);
		}
		return map;
	}

	private String value;
}

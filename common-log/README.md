日志系统（0.0.1-SNAPSHOT）
	
	已做工作
	
		简单的日志工厂，根据情况获取logger
		日志配置文件操作类
		配置全路径日志缺少日志名异常
	
	未实现部分
	
		编写后台日志系统，记录日志到数据库。
		编写日志压缩类，当日志文件达到一定大小时，进行压缩。
	
	当前遗留问题
	
		日志配置文件操作类中多处使用硬编码，需要改善。
	
	使用说明
		该项目使用maven构建，使用查看代码只需下载代码导入到eclipse中即可运行测试文件。
		classpath下log4j.properties配置文件说明
			log4j.logger.core= DEBUG, sysout #可为空，默认DEBUG

			log4j.appender.sysout = org.apache.log4j.ConsoleAppender
			log4j.appender.sysout.Target = System.out
			log4j.appender.sysout.layout = org.apache.log4j.PatternLayout
			log4j.appender.sysout.layout.ConversionPattern = [%-5p] %d{yyyy-MM-dd HH:mm:ss,SSS} method:%l%n%m%n

			log4j.appender.core=org.apache.log4j.FileAppender
			log4j.appender.core.File= #可为空，默认配置System.getProperty("user.dir")
			log4j.appender.core.layout=org.apache.log4j.PatternLayout
			log4j.appender.core.layout.ConversionPattern=[%-d{yyyy-MM-dd HH:mm:ss}][%p]-[%C.%M(%F:%L)]%m%n
		
	作者：yangkaifeng rdyang@foxmail.com
	时间：2017-7-31 23:38

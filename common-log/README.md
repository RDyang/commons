��־ϵͳ��0.0.1-SNAPSHOT��
	
	��������
	
		�򵥵���־���������������ȡlogger
		��־�����ļ�������
		����ȫ·����־ȱ����־���쳣
	
	δʵ�ֲ���
	
		��д��̨��־ϵͳ����¼��־�����ݿ⡣
		��д��־ѹ���࣬����־�ļ��ﵽһ����Сʱ������ѹ����
	
	��ǰ��������
	
		��־�����ļ��������жദʹ��Ӳ���룬��Ҫ���ơ�
	
	ʹ��˵��
		����Ŀʹ��maven������ʹ�ò鿴����ֻ�����ش��뵼�뵽eclipse�м������в����ļ���
		classpath��log4j.properties�����ļ�˵��
			log4j.logger.core= DEBUG, sysout #��Ϊ�գ�Ĭ��DEBUG

			log4j.appender.sysout = org.apache.log4j.ConsoleAppender
			log4j.appender.sysout.Target = System.out
			log4j.appender.sysout.layout = org.apache.log4j.PatternLayout
			log4j.appender.sysout.layout.ConversionPattern = [%-5p] %d{yyyy-MM-dd HH:mm:ss,SSS} method:%l%n%m%n

			log4j.appender.core=org.apache.log4j.FileAppender
			log4j.appender.core.File= #��Ϊ�գ�Ĭ������System.getProperty("user.dir")
			log4j.appender.core.layout=org.apache.log4j.PatternLayout
			log4j.appender.core.layout.ConversionPattern=[%-d{yyyy-MM-dd HH:mm:ss}][%p]-[%C.%M(%F:%L)]%m%n
		
	���ߣ�yangkaifeng rdyang@foxmail.com
	ʱ�䣺2017-7-31 23:38

package com.rdyang.log.compress;

import java.io.File;
import java.util.Map;

import org.apache.log4j.RollingFileAppender;

import com.rdyang.log.factory.LogFactory;

/**
 * 压缩日志文件，每一分钟扫描一次日志目录，当日志大小大于1M则压缩
 * @author Administrator
 *
 */
public class CompressLogFile implements Runnable {
	
	private static CompressLogFile compressLogFile = new CompressLogFile();
	
	private static int flat = 0;
	
	private long size = 1024 * 1024;//1G
	
	/**
	 * 私有构造函数
	 * 外部不允许创建实例
	 */
	private CompressLogFile() {
	}

	@Override
	public void run() {
		
	}
	
	public static void start(){
		if(flat == 0){
			Thread t = new Thread(compressLogFile);
			t.start();
			flat = 1;
		}
	}
	
	private void scanFile(){
		for (Map.Entry<String, File> entry : LogFactory.getFileMap().entrySet()) {
			File file = entry.getValue();
			if(file.exists()){
				if(file.getTotalSpace() >= size){
					compressFile(file);
				}
			}
		}
	}
	
	private void compressFile(File file){
		synchronized (file) {
			
		}
	}
	
}

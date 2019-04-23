package com.bjsxt.test;

import org.apache.log4j.Logger;

public class TestLog {
	public static	Logger  logger=Logger.getLogger(TestLog.class);
	public static void main(String[] args) {
		//获取log4j对象
		
		User u=new User();
		int b= u.getMessage(1, 2);
		logger.info("方法的执行结果为:"+b);
		System.out.println();
		logger.debug("我是debug信息");
		logger.info("我是info信息");
		logger.warn("我是警告信息");
		logger.error("我是错误信息");
		logger.fatal("我是致命的错误信息");
	}
}

package com.bjsxt.test;

import org.apache.log4j.Logger;

public class TestLog {
	public static	Logger  logger=Logger.getLogger(TestLog.class);
	public static void main(String[] args) {
		//��ȡlog4j����
		
		User u=new User();
		int b= u.getMessage(1, 2);
		logger.info("������ִ�н��Ϊ:"+b);
		System.out.println();
		logger.debug("����debug��Ϣ");
		logger.info("����info��Ϣ");
		logger.warn("���Ǿ�����Ϣ");
		logger.error("���Ǵ�����Ϣ");
		logger.fatal("���������Ĵ�����Ϣ");
	}
}

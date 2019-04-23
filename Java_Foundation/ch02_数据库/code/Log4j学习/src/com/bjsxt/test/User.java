package com.bjsxt.test;

import org.apache.log4j.Logger;

public class User {
	Logger logger=Logger.getLogger(User.class);
	public int getMessage(int a,int b){
		logger.debug("获取的实参为"+a+":"+b);
		return a+b;
	}
}

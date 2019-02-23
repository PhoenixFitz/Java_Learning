package com.klaus.singleton;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.concurrent.CountDownLatch;

/**
 * 测试多线程环境下五种创建单例模式的效率
 */
public class Client3 {

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis(); //currentTimeMillis
        int threadNum = 10;
        final CountDownLatch  countDownLatch = new CountDownLatch(threadNum);

        for(int i=0;i<threadNum;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {

                    for(int i=0;i<1000000;i++){
//                      Object o = SingletonDemo1.getInstance();
//                      Object o = SingletonDemo2.getInstance();
//                      Object o = SingletonDemo3.getInstance();
//						Object o = SingletonDemo4.getInstance();
                      Object o = SingletonDemo5.INSTANCE;
                    }

                    countDownLatch.countDown(); //计数器减1
                }
            }).start();
        }

        countDownLatch.await();	//main线程阻塞，直到计数器变为0，才会继续往下执行！

        long end = System.currentTimeMillis();
        System.out.println("总耗时："+(end-start));
    }
}
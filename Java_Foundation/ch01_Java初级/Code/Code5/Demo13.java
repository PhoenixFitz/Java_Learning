package com.bjsxt.test.jvm;

import com.bjsxt.test.annotation.Demo01;

public class Demo13 {
    public static void main(String[] args) throws Exception {
        ClassLoader loader = Demo13.class.getClassLoader();
        System.out.println(loader);


        ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
        System.out.println(loader2);

        Thread.currentThread().setContextClassLoader(new FileSystemClassLoader("c:/myjava/"));
        System.out.println(Thread.currentThread().getContextClassLoader());

        Class<Demo01> c = (Class<Demo01>) Thread.currentThread().getContextClassLoader().loadClass("com.bjsxt.test.annotation.Demo01");
        System.out.println(c);
        System.out.println(c.getClassLoader());

    }
}



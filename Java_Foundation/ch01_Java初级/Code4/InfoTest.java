package com.klaus.thread;

/**
 * 其他方法
 */
public class InfoTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().isAlive());

        //设置名称:真实角色+代理角色
        MyInfo info = new MyInfo("plane");
        Thread t = new Thread(info);
        t.setName("airplane");
        t.start();
        Thread.sleep(1000);
        System.out.println(t.isAlive());
    }
}


class MyInfo implements Runnable{
    private String name;

    public MyInfo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+name);

    }
}
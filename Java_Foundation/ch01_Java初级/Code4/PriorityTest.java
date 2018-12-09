package com.klaus.thread;

/**
 * 线程的优先级1-10
 * NORM_PRIORITY 5  默认
 * MIN_PRIORITY 1
 * MAX_PRIORITY 10
 */
public class PriorityTest {

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getPriority());
        MyPriority mp = new MyPriority();
        Thread t1 = new Thread(mp,"kl");
        Thread t2 = new Thread(mp,"chj");
        Thread t3 = new Thread(mp,"nik");
        Thread t4 = new Thread(mp,"snow");
        Thread t5 = new Thread(mp,"jack");
        Thread t6 = new Thread(mp,"rose");
        //设置优先级需要在线程启动前
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(8);
        t4.setPriority(Thread.MIN_PRIORITY);
        t5.setPriority(3);
        t6.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }


}

class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
        Thread.yield();
    }
}
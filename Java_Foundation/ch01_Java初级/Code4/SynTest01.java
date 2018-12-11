package com.klaus.thread;

/**
 * 线程安全：在并发时保证数据的正确性、效率尽可能高
 * 同步方法
 */
public class SynTest01 {
    public static void main(String[] args){
        SafeWeb12306 web = new SafeWeb12306();
        new Thread(web,"K").start();
        new Thread(web,"F").start();
        new Thread(web,"C").start();

    }
}

class SafeWeb12306 implements Runnable{
    //票数
    private int ticketNums = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while(flag){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test01();
        }
    }
    //线程安全、同步，锁住了对象，
    public synchronized void test(){
        if(ticketNums<=0){
            flag = false;
            return;
        }
        //模拟延时
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
    }


    //线程安全：尽可能锁定合理的范围（不是指代码，指数据的完整性）
    //double checking
    public void test01() {
        if (ticketNums <= 0) {  //考虑的是没有票的情况
            flag = false;
            return;
        }
        synchronized (this) {
            if (ticketNums <= 0) {  //考虑最后一张票
                flag = false;
                return;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
        }
    }
}
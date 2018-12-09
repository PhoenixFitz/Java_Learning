package com.klaus.thread;

/**
 * yield 礼让线程，暂停线程直接进入就绪状态
 */
public class YieldDemo {

    public static void main(String[] args){
        MyYield my = new MyYield();
        new Thread(my,"a").start();
        new Thread(my, "b").start();
    }


}




class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--->start");
        //礼让
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"--->end");
    }
}
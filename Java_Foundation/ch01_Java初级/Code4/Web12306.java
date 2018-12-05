package com.klaus.thread;

/**
 * 共享资源,并发
 */
public class Web12306 implements Runnable {

    //票数
    private int ticketNums = 99;
    @Override
    public void run() {
        while(true){
            if(ticketNums<0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"---->"+ticketNums--);
        }

    }

    public static void main(String[] args){
        //一份资源
        Web12306 web =new Web12306();
        //多个代理
        new Thread(web,"K").start();
        new Thread(web,"F").start();
        new Thread(web,"C").start();
    }
}

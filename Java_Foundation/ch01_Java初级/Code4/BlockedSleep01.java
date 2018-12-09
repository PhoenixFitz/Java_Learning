package com.klaus.thread;

/**
 * sleep模拟网络延时，放大放生错误的可能性
 */
public class BlockedSleep01 {

    public static void main(String[] args){


        //一份资源
        Web123060 web =new Web123060();
        //多个代理
        new Thread(web,"K").start();
        new Thread(web,"F").start();
        new Thread(web,"C").start();
    }
}

class Web123060 implements Runnable {

    //票数
    private int ticketNums = 99;

    @Override
    public void run() {
        while (true) {
            if (ticketNums < 0) {
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "---->" + ticketNums--);
        }

    }
}
package com.klaus.thread;

/**
 * 创建线程方式二
 * 1、创建：实现Runnable+重写run
 * 2、启动：创建实现类对象 +Thread对象+ start
 */
public class StartRun implements Runnable{
    /**
     * 线程入口点
     */
    @Override
    public void run() {
       for(int i=0;i<20;i++){
           System.out.println("一边听歌");
       }
    }

    public static void main(String[] args){
        //创建实现类对象
        StartRun sr = new StartRun();
        //创建代理类对象
        Thread t = new Thread(sr);
        //启动,开启线程，交给CPU调用     //st.run();  //只是普通方法的调用，执行完听歌后才执行coding
        t.start();

        //或者可以直接使用该语句，包含了“创建实现类对象 +Thread对象+ start”， new Thread(new StartRun()).start();
        for(int i=0;i<20;i++){
            System.out.println("一边coding");
        }


    }
}

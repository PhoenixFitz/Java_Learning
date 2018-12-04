package com.klaus.thread;

/**
 * 创建线程方式一
 * 1、创建：继承Thread+重写run
 * 2、启动：创建子类对象 + start
 */
public class StartThread extends Thread{
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
        //创建子类对象
        StartThread st = new StartThread();
        //启动,开启线程，交给CPU调用     //st.run();  //只是普通方法的调用，执行完听歌后才执行coding
        st.start();
        for(int i=0;i<20;i++){
            System.out.println("一边coding");
        }


    }
}

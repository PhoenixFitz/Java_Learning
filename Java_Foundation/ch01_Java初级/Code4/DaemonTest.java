package com.klaus.thread;

/**
 * 守护线程：是为用户线程服务的；jvm停止不用等待守护线程执行完毕
 * 默认：用户线程
 */
public class DaemonTest {

    public static void main(String[] args){
        God god = new God();
        You2 you = new You2();
        Thread t = new Thread(god);
        t.setDaemon(true); //将用户线程调整为守护线程
        t.start();
        new Thread(you).start();
    }

}


class You2 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<=365*100;i++){
            System.out.println("happy life..");
        }
        System.out.println("eeeee....");
    }
}

class God implements Runnable{
    @Override
    public void run() {
        for(;true;){
            System.out.println("bless you...");
        }
    }
}

package com.klaus.thread;



/**
 * join合并线程，插队线程
 */
public class BlockedJoin01 {

    public static void main(String[] ars) throws InterruptedException {
        Thread t = new Thread(()->{
            for (int i=0;i<100;i++){
                System.out.println("lambda...."+i);
            }
        });
        t.start();

        for (int i=0;i<100;i++){
            if(i==20){
                t.join();//插队 main线程被阻塞。待lambda执行完后，再执行main线程
            }
            System.out.println("main...."+i);
        }
    }

}


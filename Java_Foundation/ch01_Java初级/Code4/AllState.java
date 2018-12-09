package com.klaus.thread;


import static java.lang.Thread.*;

/**
 * 观察线程状态
 */
public class AllState {

    public static void main(String[] args){
        Thread t = new Thread(()->{
            for(int i=0;i<5;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("....");
            }
        });
        //观察状态
        State state = t.getState();
        System.out.println(state);  //NEW

        t.start();
        state = t.getState();
        System.out.println(state);  //RUNNABLE

        while(state != State.TERMINATED){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = t.getState(); //TIMED_WAITING
            System.out.println(state);
        }
        state = t.getState(); //TERMINATED
        System.out.println(state);

    }
}

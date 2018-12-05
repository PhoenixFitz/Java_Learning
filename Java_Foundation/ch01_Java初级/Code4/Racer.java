package com.klaus.thread;

/**
 * 模拟龟兔赛跑
 */
public class Racer implements Runnable{
    private String winner;

    @Override
    public void run() {
        for(int steps=1;steps<=100;steps++){
            System.out.println(Thread.currentThread().getName()+"-->"+steps);
            //比赛是否结束
            boolean flag = gameOver(steps);
            if(flag){
                break;
            }
        }

    }

    private boolean gameOver(int steps){
        if(winner!=null){  //存在胜利者
            return true;
        }else{
            if(steps==100){
                winner = Thread.currentThread().getName();
                System.out.println("Winner===>"+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Racer racer = new Racer();
        new Thread(racer,"tortoise").start();
        new Thread(racer,"rabbit").start();
    }


}

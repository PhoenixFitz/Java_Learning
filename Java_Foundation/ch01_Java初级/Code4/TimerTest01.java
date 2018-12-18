package com.klaus.thread;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度：Timer 和 TimerTask类
 */
public class TimerTest01 {
    public static void main(String[] args){
        Timer timer = new Timer();
        //timer.schedule(new MyTask(), 1000);  //执行任务一次
        timer.schedule(new MyTask(), 1000,2000); // 执行多次，2秒后再次执行
        Calendar cal = new GregorianCalendar(2020,10,6,10,6,0);
        timer.schedule(new MyTask(), cal.getTime(), 2000); //指定时间开始执行
    }

}
//任务类
class MyTask extends TimerTask{

    @Override
    public void run() {
        for(int i = 0;i<10;i++){
            System.out.println("Focus on attention!");
        }
        System.out.println("-----end------");
    }
}

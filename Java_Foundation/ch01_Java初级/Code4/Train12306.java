package com.klaus.thread;



public class Train12306 {

    public static void main(String[] args){
        Web123066 w = new Web123066(2, "peace");
        new Passenger(w, "klaus", 2).start();
        new Passenger(w, "snow", 1).start();

    }


}

//顾客
class Passenger extends Thread{
    int seats;
    public Passenger(Runnable target,String name,int seats){
        super(target,name);
        this.seats=seats;
    }
}
//火车票网
class Web123066 implements Runnable{
    int available; //可用的位置
    String name; //名称

    public Web123066(int available, String name) {
        this.available = available;
        this.name = name;
    }

    @Override
    public void run() {
        Passenger p = (Passenger)Thread.currentThread();
        boolean flag = this.bookTickets(p.seats);
        if (flag) {
            System.out.println("欢迎来到列车"+this.name+"号  出票成功:" + Thread.currentThread().getName() + "-<位置为:" + p.seats);
        } else {
            System.out.println("欢迎来到列车"+this.name+"号  出票失败:" + Thread.currentThread().getName() + "-<位置不够");
        }
    }

    public synchronized boolean bookTickets(int seats){
        System.out.println("可用位置为:"+available);
        if(seats>available){
            return false;
        }
        available -= seats;
        return true;
    }
}
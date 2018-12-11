package com.klaus.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟影院购票选座
 */
public class CinemaTest {

    public static void main(String[] args){
        //可用位置
        List<Integer> available = new ArrayList<Integer>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(4);
        available.add(6);
        available.add(7);

        //顾客需要的位置
        List<Integer> seat1 = new ArrayList<Integer>();
        seat1.add(1);
        seat1.add(2);
        List<Integer> seat2 = new ArrayList<Integer>();
        seat2.add(4);
        seat2.add(5);
        seat2.add(6);
        Cinema c = new Cinema(available, "Paradise");
        new Thread(new Customer(c, seat1),"Klaus").start();
        new Thread(new Customer(c, seat2),"Snow").start();
    }
}


//顾客
class Customer implements Runnable{
    Cinema cinema;
    List<Integer>seats;

    public Customer(Cinema cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.bookTickets(seats);
            if (flag) {
                System.out.println("出票成功" + Thread.currentThread().getName() + "-<位置为:" + seats);
            } else {
                System.out.println("出票失败" + Thread.currentThread().getName() + "-<位置不够");
            }
        }
    }
}

class Cinema{
    List<Integer> available; //可用的位置
    String name; //名称

    public Cinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }


    //购票
    public boolean bookTickets(List<Integer> seats){
        System.out.println("欢迎光临"+this.name+"可用位置为："+available);
        List<Integer> copy = new ArrayList<Integer>();
        copy.addAll(available);
        //相减
        copy.removeAll(seats);
        //判断大小
        if(available.size()-copy.size()!=seats.size()){
            return false;
        }
        //成功
        available = copy;
        return true;
    }
}

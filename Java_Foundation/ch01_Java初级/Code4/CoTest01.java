package com.klaus.thread;

/**
 * 协作模型：生产者消费者实现方式一：管程法
 * 借助缓冲区
 *
 */
public class CoTest01 {
    public static void main(String[] args){
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();

    }

}

//生产者
class Productor extends Thread{
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //生产
        for(int i=0;i<100;i++){
            System.out.println("生产--->"+i+"个馒头");
            container.push(new Steamedbun(i));
        }
    }
}
//消费者
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }
    //消费
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("消费--->"+container.pop().id+"个馒头");
        }

    }
}
//缓冲区
class SynContainer{
    Steamedbun[] buns = new Steamedbun[10];
    int count = 0;//计数器
    //存储
    public synchronized void push(Steamedbun bun){
        //何时能生产，容器存在空间
        //不能生产
        if(count == buns.length){
            try {
                this.wait(); ////线程阻塞  消费者通知消费 解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在空间
        buns[count] = bun;
        count++;
        //存在数据，可以通知消费
        this.notifyAll();
    }
    //获取
    public synchronized Steamedbun pop(){
        //何时能消费 容器中是否存在数据
        //没有数据 只有等待
        if(count == 0){
            try {
                this.wait();  //线程阻塞  生产者通知消费 解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在数据
        count--;
        Steamedbun bun = buns[count];
        this.notifyAll(); //存在空间，唤醒对方生产
        return bun;
    }

}
//馒头

class Steamedbun{
    int id;

    public Steamedbun(int id) {
        this.id = id;
    }
}

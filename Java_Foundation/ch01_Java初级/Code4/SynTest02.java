package com.klaus.thread;

/**
 * 同步块
 */
public class SynTest02 {

    public static void main(String[] args){
        //账户
        Account account = new Account(100, "学习基金");
        SynDrawing ky = new SynDrawing(account, 80, "考研");
        SynDrawing buybook = new SynDrawing(account, 40, "买书");
        ky.start();
        buybook.start();
    }
}


//模拟取款 线程安全
class SynDrawing extends Thread{
    Account account;//取钱账户
    int drawingMoney;//取的钱数
    int packetTotal;//口袋总数

    public SynDrawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        test();
    }

    //目标锁定account
    public void test(){
        //性能优化
        if(account.money<0){
            return;
        }
        //同步块
        synchronized(account){
            if(account.money-drawingMoney<0){
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money-=drawingMoney;
            packetTotal+=drawingMoney;
            System.out.println(this.getName()+"--->账户余额为："+account.money);
            System.out.println(this.getName()+"--->口袋的钱为："+packetTotal);
        }
    }
}

class Account{
    int money;  //金额
    String name;  // 名称

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

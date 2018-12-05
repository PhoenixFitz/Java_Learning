package com.klaus.thread;

/**
 * 静态代理
 * 公共接口
 * 1、真实角色
 * 2、代理角色
 */
public class StaticProxy {
    public static void main(String[] args){
        new WeddingCompany(new You()).happyMary();;
    }
}

interface Marry{
    void happyMary();
}

class You implements Marry{
    @Override
    public void happyMary() {
        System.out.println("you and me are married");
    }
}

//代理角色
class WeddingCompany implements Marry{
    //真实角色
    private Marry target;
    public WeddingCompany(Marry target){
        this.target =target;
    }
    @Override
    public void happyMary() {
        ready();
        this.target.happyMary();
        after();
    }

    private void ready(){
        System.out.println("布置卧室");
    }

    private void after(){
        System.out.println("收拾房间");
    }
}
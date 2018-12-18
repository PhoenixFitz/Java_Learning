package com.klaus.thread;

/**
 * DCL单例模式：在多线程环境下，对外存在一个对象
 * 1、构造器私有化-->避免外部new构造器
 * 2、提供私有的静态属性-->存储对象的地址
 * 3、提供公共的静态方法-->获取属性
 */
public class DoubleCheckedLocking {
    //2、提供私有的静态属性
    private static volatile DoubleCheckedLocking instance; //避免指令重排，若没有volatile，其他线程可能访问一个没有初始化的对象

    //1、构造器私有化
    private  DoubleCheckedLocking(){

    }

    //3、提供公共的静态方法
    public static DoubleCheckedLocking getInstance(){
        //再次检测
        if(instance != null){  //避免不必要的同步，已经存在对象
            return instance;
        }
        synchronized(DoubleCheckedLocking.class) {
            if (instance == null) {
                instance = new DoubleCheckedLocking(); //开辟空间、初始化对象信息、返回对象的地址给引用
            }
        }
        return instance;
    }

    public static DoubleCheckedLocking getInstance1(long time){

            if (instance == null) {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new DoubleCheckedLocking();
            }

        return instance;
    }

    public static void main(String[] args){
//        Thread t = new Thread(()->{
//            System.out.println(DoubleCheckedLocking.getInstance());
//        });
//        t.start();
//        System.out.println(DoubleCheckedLocking.getInstance());

        //出现地址不一致
        Thread t1 = new Thread(()->{
            System.out.println(DoubleCheckedLocking.getInstance1(1000));
        });
        t1.start();
        System.out.println(DoubleCheckedLocking.getInstance1(500));

    }


}

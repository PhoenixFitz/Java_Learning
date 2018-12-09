package com.klaus.thread;

/**
 * Lambda表达式， 简化线程（用一次）的使用
 */
public class LambdaThread {
    //静态内部类
    static class Test implements Runnable {

        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("一边听歌");
            }
        }

    }

    public static void main(String[] args){


        new Thread(new Test()).start();

        for(int i=0;i<20;i++){
            System.out.println("一边coding");
        }

        //局部内部类
        class Test2 implements Runnable {

            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("一边听歌");
                }
            }

        }

        new Thread(new Test2()).start();

        //匿名内部类  必须借助接口或者父类

        new Thread(new Runnable(){
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("一边听歌");
                }
            }
        }).start();

        //简化lambda,只能是一个方法

        new Thread(()->{
                for (int i = 0; i < 20; i++) {
                    System.out.println("一边听歌");
                }
            }).start();

        //一行代码 省略版lambda
        new Thread(()-> System.out.println("实验室跑数据")).start();
    }
}

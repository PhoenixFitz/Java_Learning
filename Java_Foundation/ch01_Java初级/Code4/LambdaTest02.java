package com.klaus.thread;

/**
 * lambda + 参数
 */

public class LambdaTest02 {

    public static void main(String[] args) {
        //lambda
        ILove love = (int a) -> {
            System.out.println("I love lambda -->" + a);
        };
        love.lambda(100);
        // 简化
        love = (a) -> {
            System.out.println("I love lambda -->" + a);
        };
        love.lambda(50);

        //只有一个参数的情况，括号也可以省略
        love = a -> {
            System.out.println("I love lambda -->" + a);
        };
        love.lambda(10);
        //只有一行代码的情况，可如下简化
        love = a ->System.out.println("I love lambda -->" + a);
        love.lambda(1);

    }
}
interface ILove{
    void lambda(int a);

}
//外部类
class Love implements ILove {
    @Override
    public void lambda(int a) {
        System.out.println("I love lambda -->" + a);
    }
}
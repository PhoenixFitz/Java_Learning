package com.klaus.thread;

/**
 * lambda+参数+返回值
 */
public class LambdaTest03 {

    public static void main(String[] args){
        IInterest interest =(int a, int c) ->{
            System.out.println("I am interested in lambda --->"+(a+c));
            return a+c;
        };
        interest.lambda(111, 222);

        interest =(a, c) ->{
            System.out.println("I am interested in lambda --->"+(a+c));
            return a+c;
        };
        interest.lambda(11, 22);
    }
}


interface IInterest{
    int lambda(int a,int b);
}

//外部类
class Interest implements IInterest{
    @Override
    public int lambda(int a, int c) {
        System.out.println("I am interested in lambda --->"+(a+c));
        return a+c;
    }
}
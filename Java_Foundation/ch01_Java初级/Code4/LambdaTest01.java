package com.klaus.thread;

public class LambdaTest01 {

    static class Like2 implements ILike{
        //内部类
        public void lambda() {
            System.out.println("I like lambda2.");
        }
    }
    public static void main(String[] args){
        ILike like = new Like();
        like.lambda();
        like = new Like2();
        like.lambda();
        //匿名内部类
        like = new ILike() {public void lambda() {
            System.out.println("I like lambda3.");
            }
        };
        like.lambda();

        //lambda
        like = ()-> {
            System.out.println("I like lambda4.");
            };
        like.lambda();
        }
    }



interface ILike{
    void lambda();

}
//外部类

class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("I like lambda.");
    }
}
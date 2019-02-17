package com.bjsxt.test.annotation;

import java.util.Date;

public class Demo01 /* extends Object*/{

    @Override
    public String toString(){
        return "";
    }

    @Deprecated
    public static void test001(){
        System.out.println("sss");
    }
    public static void main(String[] args){
        Date d = new Date();
        test001();
    }

}

package com.bjsxt.test.annotation;

public class Demo02 {

    @SxtAnnotation01(age = 11,studentName = "klaus") //也可以自己显示定义参数
    public void test(){

    }

    @SxtAnnotation02(value = "aaa") //只有一个属性 可以直接写成 "aaa"
    public void test2(){

    }
}

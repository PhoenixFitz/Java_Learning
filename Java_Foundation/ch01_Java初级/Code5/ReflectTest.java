package com.klaus.sever;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射Reflection：把java类中的各种结构（方法、属性、构造器、类名）映射成一个个的java对象
 * 1.获取class对象
 * 三种方式：推荐 Class.forName("完整路径")
 * 2.可以动态创建对象
 * clz.getConstructor().newInstance()
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //三种方式
        //1、对象.getClass()
        Iphone iphone = new Iphone();
        Class clz = iphone.getClass();
        //2、类.class
        clz = Iphone.class;
        //3、Class.forName("包名.类名")
        clz = Class.forName("com.klaus.sever.Iphone");

        //创建对象
        Iphone iphone1 = (Iphone)clz.getConstructor().newInstance();
        System.out.println(iphone1);

    }
}


class Iphone{
    public Iphone(){

    }
}
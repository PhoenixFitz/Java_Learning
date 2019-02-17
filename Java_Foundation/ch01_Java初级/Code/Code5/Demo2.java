package com.bjsxt.test.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的API，获取类的信息（类的名字、属性、方法、构造器等）
 */
public class Demo2 {
    public static void main(String[] args){
        String path = "com.bjsxt.test.reflection.User";
        try {
            Class clazz = Class.forName(path);

            //获取类的名字
            System.out.println(clazz.getName()); //获得包名+类名：com.bjsxt.test.reflection.User
            System.out.println(clazz.getSimpleName()); //获取类名：User

            //获取属性信息
            Field[] fields = clazz.getFields(); //只能获得public的field
            Field[] fields1 = clazz.getDeclaredFields(); //获得所有的field
            Field f = clazz.getDeclaredField("uname");
            System.out.println(fields.length);
            System.out.println(fields1.length);
            for(Field temp:fields1){
                System.out.println("属性："+temp);
            }

            //获取方法信息
            Method[] methods = clazz.getDeclaredMethods();
            Method m01 = clazz.getDeclaredMethod("getUname",null);
            //如果方法有参，则必须传递参数类型对应的class对象
            Method m02 = clazz.getDeclaredMethod("setUname", String.class);
            for(Method m:methods){
                System.out.println("方法："+m);
            }
            //获取构造器信息
            Constructor[] constructors = clazz.getDeclaredConstructors();
            for(Constructor temp:constructors){
                System.out.println("构造器："+temp);
            }
            Constructor c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
            System.out.println("获得构造器"+c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

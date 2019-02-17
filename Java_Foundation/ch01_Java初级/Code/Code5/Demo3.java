package com.bjsxt.test.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射API动态的操作：构造器、方法、属性
 *
 */
public class Demo3 {
    public static void main(String[] args){
        String path = "com.bjsxt.test.reflection.User";
        try {
            Class clazz = Class.forName(path);

            //通过反射API动态调用构造方法，构造对象
            User u = (User) clazz.newInstance(); //其实是调用了User的无参构造方法
            System.out.println(u);

            Constructor<User> c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
            User u2 = c.newInstance(1001,18,"klaus");
            System.out.println(u2.getUname());

            //通过反射API调用普通方法
            User u3 = (User)clazz.newInstance();
            //动态调用普通方法u3.setUname("niklaus");
            Method method = clazz.getDeclaredMethod("setUname", String.class);
            method.invoke(u3,"niklaus");
            System.out.println(u3.getUname());

            //通过反射API操作属性
            User u4 = (User)clazz.newInstance();
            Field f = clazz.getDeclaredField("uname");
            f.setAccessible(true);//私有属性只能自己访问，该语句后，表示这个属性不需要做安全检查，可以直接访问
            f.set(u4, "Snow"); //通过反射直接写属性
            System.out.println(u4.getUname()); //通过反射直接读属性
            System.out.println(f.get(u4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

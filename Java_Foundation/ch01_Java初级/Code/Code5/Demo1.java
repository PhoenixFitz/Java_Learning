package com.bjsxt.test.reflection;

/**
 * 测试java.lang.Class对象的获取方式
 */
@SuppressWarnings("all")
public class Demo1 {
    public static void main(String[] args){
        String path = "com.bjsxt.test.reflection.User";

        try {
            Class clazz = Class.forName(path);
            //对象是表示或封装一些数据，一个类被加载后，JVM会创建一个对应该类的整个结构信息会放到对应的Class对象中
            //通过该Class对象可以看到对应类的全部信息
            System.out.println(clazz);
            System.out.println(clazz.hashCode());

            Class clazz2 = Class.forName(path); //一个类只对应一个Class对象
            System.out.println(clazz2.hashCode());
            //Class类的获取
            Class strClazz = String.class;
            Class strClazz2 = path.getClass();

            int[] arr01 = new int[10];
            int[] arr02 = new int[30];
            int[][] arr03 = new int[30][3];
            System.out.println(arr01.getClass().hashCode());
            System.out.println(arr02.getClass().hashCode());// arr01 arr02 是同一个Class类对象
            System.out.println(arr03.getClass().hashCode());
            System.out.println("实时");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

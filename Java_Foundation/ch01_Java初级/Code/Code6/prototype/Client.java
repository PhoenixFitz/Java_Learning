package com.klaus.prototype;

import java.util.Date;

/**
 * 测试原型模式(浅克隆）
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Date date = new Date(1587632215);
        Sheep s1 = new Sheep("Penny",date);
        Sheep s2 = (Sheep) s1.clone();
        System.out.println(s1);
        System.out.println(s1.getSname());
        System.out.println(s1.getBirthday());
        System.out.println(s2.getBirthday());

        date.setTime(23432432423L);
        System.out.println(s1.getBirthday());


        s2.setSname("Sheldon");
        System.out.println(s2);
        System.out.println(s2.getSname());
        System.out.println(s2.getBirthday());
    }
}

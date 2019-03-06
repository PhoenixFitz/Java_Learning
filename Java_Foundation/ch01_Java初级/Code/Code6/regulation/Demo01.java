package com.klaus.test;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式对象的基本用法
 * @author Administrator
 *
 */
public class Demo01 {

    public static void main(String[] args){
        //在这个字符串：asfsdf23323，是否符合指定的正则表达式：\w+
        //表达式对象

        Pattern p = Pattern.compile("\\w+");

        //创建Matcher
        Matcher m = p.matcher("asfsd&f23323");  //尝试将整个字符序列与该模式匹配

        //boolean b = m.matches();

//        //System.out.println(b);
//        boolean b2 = m.find(); //该方法扫描输入的序列，查找与该模式匹配的下一个子序列
//        System.out.println(b2);
//        System.out.println(m.find());
//        System.out.println(m.find());


        while(m.find()){
            System.out.println(m.group());	//group(),group(0)匹配整个表达式的子字符串
            System.out.println(m.group(0));
        }



    }
}

package com.klaus.io;

import java.io.*;

/**
 * 第一个程序
 */
public class IOTest01 {
    public static void main(String[] args){

        //创建流
        File src=new File("test.txt");
        //选择流
        try {
            InputStream is= new FileInputStream(src);
            //读取
            int data1=is.read(); //F
            int data2=is.read();//i
            int data3=is.read();//t
            int data4=is.read();//文件末尾 返回-1
            System.out.println(data1);
            System.out.println((char)data1);
            System.out.println((char)data2);
            System.out.println((char)data3);
            System.out.println(data4);
            //释放资源
            is.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

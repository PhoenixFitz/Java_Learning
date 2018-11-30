package com.klaus.io;

import java.io.*;

/**
 * 文件字符输出流 加入缓冲流
 *
 */

public class BufferedTest03 {
    public static void main(String[] args){
        //创建源
        File dest=new File("dest.txt");
        //选择流
        BufferedWriter writer=null;

        try {

            writer=new BufferedWriter(new FileWriter(dest));
            //操作；写出
            //写法一

            /*String msg="IO is very useful\r\n好好学习";
            char[] datas=msg.toCharArray();//字符串-->字符数组
            writer.write(datas,0,datas.length); */

            //写法二

            /*String msg="IO is very useful\r\n好好学习";
            writer.write(msg); */


            //写法三
            writer.append("IO is very useful");
            writer.newLine();   //换行
            writer.append("好好学习");

            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

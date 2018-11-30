package com.klaus.io;


import java.io.*;

/**
 * 转换流 InputStreamReader  OutputStreamWriter
 * 1.以字符流的形式操作字节流（纯文本）
 * 2.指定字符集
 */
public class ConvertTest {
    public static void main(String[] args){
        //操作System.in 和 System.out
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));){
            //循环获取键盘的输入（exit退出），输出此内容
            String msg = "";
            while(!msg.equals("exit")){
                msg = reader.readLine();//循环读取
                writer.write(msg);//循环写出
                writer.newLine();
                writer.flush(); //强制刷新
            }

        }catch (IOException e){
            System.out.println("操作异常");

        }



    }
}

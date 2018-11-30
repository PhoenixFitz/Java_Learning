package com.klaus.io;


import java.io.*;
import java.net.URL;


/**
 * 转换流 InputStreamReader  OutputStreamWriter
 * 1.以字符流的形式操作字节流（纯文本）
 * 2.指定字符集
 */
public class ConvertTest02 {
    public static void main(String[] args) {
        //操作网络流
        try (BufferedReader reader =new BufferedReader(
                new InputStreamReader(
                        new URL("http://www.baidu.com").openStream(),"UTF-8"));
             BufferedWriter writer =new BufferedWriter(
                     new OutputStreamWriter(
                             new FileOutputStream("baidu.html"),"UTF-8"));) {
            String msg;
            while((msg=reader.readLine())!=null){
                System.out.print(msg);
                writer.write(msg);
                writer.newLine();
            }
            writer.flush();

        } catch (IOException e) {
            System.out.println("操作异常");

        }


    }
}


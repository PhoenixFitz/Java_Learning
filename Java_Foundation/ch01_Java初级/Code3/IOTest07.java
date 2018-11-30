package com.klaus.io;
/**
 * 字节数组输入流
 * 创建源： 字节数组 不要太大
 * 释放资源：可以不用关闭
 */

import java.io.*;

public class IOTest07 {
    public static void main(String[] args){
        //创建源
        byte[] src="talk is cheap show me the code".getBytes();
        //选择流
        InputStream is=null;
        try {
            is = new ByteArrayInputStream(src);
            //分段读取
            byte[] flush=new byte[5];  //缓冲容器
            int len=-1;  //接收长度
            while((len=is.read(flush))!=-1){
                //字节数组->字符串(解码)
                String str =new String(flush,0,len);
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(is!=null) { //避免文件源未创建成功
                    //释放资源
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.klaus.io;
/**
 * 每次读取多个字节，字节输入流
 */

import java.io.*;

public class IOTest03 {
    public static void main(String[] args){
        File src=new File("test.txt");
        InputStream is=null;
        try {
            is = new FileInputStream(src);
            //分段读取
            byte[] flush=new byte[3];  //缓冲容器
            int len=-1;  //接收长度
            while((len=is.read(flush))!=-1){
                //字节数组->字符串(解码)
                String str =new String(flush,0,len);
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
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

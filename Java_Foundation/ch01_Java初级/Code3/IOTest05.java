package com.klaus.io;
/**
 * 文件字符输入流
 */

import java.io.*;

public class IOTest05 {
    public static void main(String[] args){
        File src=new File("test.txt");
        Reader reader=null;
        try {
            reader = new FileReader(src);
            //读取
            char[] flush = new char[1024];//缓冲容器
            int len=-1; //接收长度
            while((len=reader.read(flush))!=-1){
                //字节数组-->字符串
                String str = new String(flush,0,len);
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(reader !=null) { //避免文件源未创建成功
                    //释放资源
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.klaus.io;

import java.io.*;

public class IOTest02 {
    public static void main(String[] args){
        File src=new File("test.txt");
        InputStream is=null;
        try {
            is = new FileInputStream(src);
            //读取
            int temp;
            while((temp=is.read())!=-1){
                System.out.println((char)temp);
            }
        //释放资源



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(is!=null) { //避免文件源未创建成功
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

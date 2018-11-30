package com.klaus.io;

import java.io.*;

/**
 * 1.封装拷贝
 * 2.封装释放资源
 */
public class FileUtils {

    public static void main(String[] args){
        //文件到文件
        try {
            InputStream is = new FileInputStream("test.txt");
            OutputStream os = new FileOutputStream("test-copy.txt");
            copy(is, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //文件到字节数组
        byte[] datas = null;
        try {
            InputStream is = new FileInputStream("p-byte.jpg");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            copy(is, os);
            datas = os.toByteArray();
            System.out.println(datas.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //字节数组到文件
        try {
            InputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("p-copy2.jpg");
            copy(is, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    //对接输入输出流
    public static void copy(InputStream is,OutputStream os) {

        try {

            //操作 分段读取
            byte[] flush = new byte[1024];//缓冲容器
            int len = -1;
            while((len=is.read(flush))!=-1){
                os.write(flush,0,len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {  //释放资源 分别关闭，先打开的后关闭， 这里输入文件先打开，所以后关闭

            close(is, os);
    }


    }
    //释放资源
    public static void close(InputStream is,OutputStream os){
        try {
            if(os!=null) {
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            if(is!=null) {
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void close(Closeable... ios){
        for(Closeable io:ios){
            try {
                if(io!=null) {
                    io.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
package com.klaus.io;

import java.io.*;

/**
 * 使用文件字节输入、输出流 进行文件拷贝
 */
public class Copy {
    public static void main(String[] args){
        copy("src/com/klaus/io/Copy.java", "copy.txt");

}

public static void copy(String srcPath,String destPath) {
    //创建源
    File dest=new File(destPath); //目的地
    File src=new File(srcPath);//源头
    //选择流
    OutputStream os=null;
    InputStream is=null;

        try {
        is = new FileInputStream(src);
        os=new FileOutputStream(dest);
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


  }

}

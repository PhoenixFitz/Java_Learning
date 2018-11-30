package com.klaus.io;

import java.io.*;

/**
 * 图片读取到字节数组中
 * 字节数组写出到文件
 */
public class IOTest09 {
    public static void main(String[] args){
        byte[] datas = fileToByteArray("src/genji.jpg");
        System.out.println(datas.length);
        byteArrayToFile(datas, "p-byte.jpg");

    }

    //图片读取到字节数组,图片到程序FileInputStream，程序到字节数组ByteArrayOutputStream
    public static byte[] fileToByteArray(String filePath){
        //创建源与目的地
        File src = new File(filePath);
        byte[] dest=null;
        //选择流
        InputStream is = null;
        ByteArrayOutputStream baos=null;

        try {
            is = new FileInputStream(src);
            baos = new ByteArrayOutputStream();
            byte[] flush=new byte[1024*10];
            int len=-1;
            while((len=is.read(flush))!=-1){
                baos.write(flush, 0, len);  //写出到字节数组中
            }
            baos.flush();
            return baos.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                if(is!=null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    //字节数组写出到图片,字节数组到程序ByteArrayInputStream,程序到文件FileOutputStream
    public static void byteArrayToFile(byte[] src,String filePath){
        //创建源
        File dest = new File(filePath);
        //选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(dest);
            //操作 分段读取
            byte[] flush = new byte[5]; //缓冲容器
            int len =-1;
            while((len=is.read(flush))!=-1){
                os.write(flush, 0, len);  //写出到文件
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            try {
                if(os!=null){
                 os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

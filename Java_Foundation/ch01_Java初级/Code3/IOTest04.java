package com.klaus.io;

import java.io.*;

/**
 * 文件字节输出流
 * 创建源，选择流，操作（写出内容），释放资源
 */

public class IOTest04 {
    public static void main(String[] args){
        //创建源
        File dest=new File("dest.txt");
        //选择流
        OutputStream os=null;

        try {
            os=new FileOutputStream(dest,true); //加了append 标签后，若为true ，可以直接在文本后面追加，不会覆盖
            //操作；写出
            String msg="IO is very useful\r\n";
            byte[] datas=msg.getBytes();//字符串-->字符数组（编码）
            os.write(datas,0,datas.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

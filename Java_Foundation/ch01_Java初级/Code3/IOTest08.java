package com.klaus.io;

import java.io.*;

/**
 * 字节数组输出流  ByteArrayOutputStream
 * 创建源，内部维护
 * 选择流，不关联源
 * 操作（写出内容），
 * 释放资源，可以不用关闭
 * 获取数据： toByteArray();
 */

public class IOTest08 {
    public static void main(String[] args){
        //创建源
        byte[] dest=null;
        //选择流(新增方法),不能直接使用父类OutputStream
        ByteArrayOutputStream baos=null;

        try {
           baos=new  ByteArrayOutputStream(); //加了append 标签后，若为true ，可以直接在文本后面追加，不会覆盖
            //操作；写出
            String msg="show me the lights";
            byte[] datas=msg.getBytes();//字符串-->字符数组（编码）
            baos.write(datas,0,datas.length);
            baos.flush();
            //获取数据

            dest = baos.toByteArray();
            System.out.println(dest.length+"-->"+new String(dest,0,baos.size()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

package com.klaus.io;

import java.io.UnsupportedEncodingException;

/**
 * 编码：字符串-->字节
 * 解码：字节-->字符串
 */
public class ContentEncode {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg="性命生命使命a";
        //编码
        byte[] datas=msg.getBytes();  //默认使用工程的字符集
        System.out.println(datas.length);

        //编码其他字符集
        datas=msg.getBytes("UTF-16LE");
        System.out.println(datas.length);

        //解码 String​(byte[] bytes, int offset, int length, String charsetName)
        String msg02=new String(datas,0,datas.length,"UTF-16LE");
        System.out.println(msg02);

        //出现乱码的情况： 1）字节数不够，2）字符集不统一，
    }
}

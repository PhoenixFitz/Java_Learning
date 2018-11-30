package com.klaus.io;

import java.io.*;

public class BufferedTest01 {

    public static void main(String[] args){
        //精简版
        File src = new File("text.txt");
        InputStream is = null;

        try {
            is = new BufferedInputStream(new FileInputStream(src));  //直接在字节流外面加上BufferedInputStream就可以了
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len=is.read(flush))!=-1){
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void test1(){
        File src = new File("text.txt");
        InputStream is = null;
        BufferedInputStream bis = null;

        try {
            is = new FileInputStream(src);
            bis = new BufferedInputStream(is);
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len=is.read(flush))!=-1){
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(bis!=null){
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }  //详细的版本
}

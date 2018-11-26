package com.klaus.io;

import java.io.File;

/**
 * 统计文件夹大小
 * 
 */
public class FileDemo05 {


    public static void main(String[] args){
        File dir=new File("C:/Users/hanbaozhen1/IdeaProjects/IO_study");
        count(dir);
        System.out.println(len);

    }

    private static long len=0;
    public static void count(File src){
        //获取大小
        if(null!=src&&src.exists()){
            if(src.isFile()){
                len+=src.length();

            }else{
                for(File s:src.listFiles()){
                    count(s);
                }
            }
        }
    }
}

package com.klaus.io;

import java.io.File;

/**
 * 创建目录
 * mkdir(); 确保上级目录存在，不存在则创建失败
 * mkdirs(); 上级目录可以不存在，若不存在则一同创建
 */
public class FileDemo03 {
    public static void main(String[] args){
        File dir=new File("C:/Users/hanbaozhen1/IdeaProjects/IO_study/dir/test1");
        //创建目录 mkdirs();
        boolean flag = dir.mkdirs();
        System.out.println(flag);

        //列出下一级 list()列出下级名称    listFiles();列出下级File对象
        File src=new File("C:/Users/hanbaozhen1/IdeaProjects/IO_study/");

        //列出下级名称

        String[] subNames= src.list();
        for(String s:subNames) {
            System.out.println(s);
        }

        //下级对象
        File[] subFiles =src.listFiles();
        for(File s:subFiles){
            System.out.println(s.getAbsolutePath());
        }

        //列出所有的盘符 listRoots();
        File[] roots=src.listRoots();
        for(File r:roots){
            System.out.println(r);
        }


    }

}

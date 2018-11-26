package com.klaus.io;

import java.io.File;

/**
 * 递归：打印子孙级目录和文件的名称
 *
 */
public class FileDemo04 {


    public static void main(String[] args){
        File dir=new File("C:/Users/hanbaozhen1/IdeaProjects/IO_study");
        printName(dir,0);

    }

    public static void printName(File file,int deep){
        for(int i=0;i<deep;i++){
            System.out.print("-");
        }
        System.out.println(file.getName());
        if(file==null||!file.exists()){// 递归头
            return;
        }else if(file.isDirectory()){
            for(File s:file.listFiles()){
                printName(s,deep+1);
            }
        }
    }


}

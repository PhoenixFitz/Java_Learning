package com.klaus.io;


import java.io.File;

/**
 * 名称分隔符
 */
public class PathDemo01 {

    public static  void main(String[] args){
        // \（windows） or /（Linux） 名称分隔符
        String path="C:\\Users\\hanbaozhen1\\IdeaProjects\\IO_study\\src\\com\\klaus\\io\\test.jpg";
        System.out.println(File.separatorChar);

        //建议路径写法
        //1、  /
        path="C:/Users/hanbaozhen1/IdeaProjects/IO_study/src/com/klaus/io/test.jpg";
        System.out.println(path);
        //2、 常量拼接
        path="C:"+File.separator+"Users"+File.separator+"hanbaozhen1"+File.separator+"IdeaProjects"+File.separator+"IO_study"
                +File.separator+"src"+File.separator+"com"+File.separator+"klaus"+File.separator+"io"+File.separator+"test.jpg";
        System.out.println(path);
    }
}

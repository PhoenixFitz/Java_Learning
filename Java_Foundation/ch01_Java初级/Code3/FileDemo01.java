package com.klaus.io;

import java.io.File;

/**
 * 构造器
 * 绝对路径与相对路径
 */
public class FileDemo01 {
    public static void main(String[] args){
        //构建File对象
        String path="C:/Users/hanbaozhen1/IdeaProjects/IO_study/src/genji.jpg";
        File src =new File(path);
        System.out.println(src.length());

        //构建方法2
        src=new File("C:/Users/hanbaozhen1/IdeaProjects/IO_study/src", "genji.jpg");
        // src=new File("C:/Users/hanbaozhen1/IdeaProjects", "/IO_study/src/genji.jpg");  //这个方法也是可以的
        System.out.println(src.length());

        //构建方法3
        src =new File(new File("C:/Users/hanbaozhen1/IdeaProjects/IO_study/src"), "genji.jpg");
        System.out.println(src.length());

        //绝对路径
        File source = new File(path);
        System.out.println(source.getAbsolutePath());

        //相对路径
        System.out.println(System.getProperty("user.dir"));
        source = new File("genji.jpg");   //也可以构建一个不存在的文件。
        System.out.println(source.getAbsolutePath());

    }
}

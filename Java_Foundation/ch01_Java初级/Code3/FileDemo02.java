package com.klaus.io;

import java.io.File;
import java.io.IOException;

/**
 * 名称和路径
 * getName()
 * getPath() :返回相对或者绝对路径
 * getAbsolutePath()
 * getParent():返回上个路径
 */
public class FileDemo02 {

    public static void main(String[] args) throws IOException {

        //基本信息
        File src =new File("src/genji.jpg");
        System.out.println("名称"+src.getName());
        System.out.println("路径"+src.getPath());
        System.out.println("绝对路径"+src.getAbsolutePath());
        System.out.println("父路径"+src.getParent());

        //文件状态
        //不存在：exists
        //存在：文件——isFile     文件夹——isDirectory

        System.out.println("是否存在："+src.exists());
        System.out.println("是否文件："+src.isFile());
        System.out.println("是否是文件夹："+src.isDirectory());

        //文件状态
        File src02 = new File("xxx");
        if(src02==null||!src02.exists()) {
            System.out.println("文件不存在");
        }
            else{
                if(src02.isFile()){
                    System.out.println("文件操作");
                }else{
                    System.out.println("文件夹操作");
                }
            }
        //其他信息， length() 返回文件的字节数，若为文件夹，返回0
        System.out.println("长度"+src.length());

        //createNewFile();  文件不存在时，才会创建成功

        File src03=new File("test.txt");
        boolean flag;
        if (src03.createNewFile()) {  //文件不存在才会创建
            flag = true;
        } else flag = false;
        System.out.println(flag);
        System.out.println(src03.getAbsolutePath());

        System.out.println("-----测试删除-----");
        src03=new File("C:/Users/hanbaozhen1/IdeaProjects/IOstudy"); //创建的不是文件夹
        flag=src03.createNewFile();
        System.out.println(flag);

        flag=src03.delete();
        System.out.println(flag);



    }
}

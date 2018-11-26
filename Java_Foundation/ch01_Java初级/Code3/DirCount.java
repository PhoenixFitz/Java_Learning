package com.klaus.io;

import java.io.File;

/**
 * 使用面向对象：统计文件夹的大小
 */
public class DirCount{
    private long len;//大小
    private String path;//文件夹路径
    private int fileSize;
    private int dirSize;
    private File src;
    public DirCount(String path){
        this.path=path;
        this.src=new File(path);
        count(this.src);

    }



    public long getLen() {
        return len;
    }

    public int getFileSize() {
        return fileSize;
    }

    public int getDirSize() {
        return dirSize;
    }

    private  void count(File src){
        //获取大小
        if(null!=src&&src.exists()){
            if(src.isFile()){
                len+=src.length();
                this.fileSize++;

            }else{
                this.dirSize++;
                for(File s:src.listFiles()){
                    count(s);
                }
            }
        }
    }

    public static void main(String[] args){
        DirCount dir=new DirCount("C:/Users/hanbaozhen1/IdeaProjects/IO_study");
        System.out.println(dir.getLen()+"--"+"文件数量："+dir.getFileSize()+"--"+"文件夹数量："+dir.getDirSize());

        DirCount dir2=new DirCount("C:/Users/hanbaozhen1/IdeaProjects/IO_study/src");
        System.out.println(dir2.getLen()+"--"+"文件数量："+dir.getFileSize()+"--"+"文件夹数量："+dir.getDirSize());

    }
}

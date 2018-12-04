package com.klaus.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 拷贝
 */
public class CIOTest02 {
    public static void main(String[] args) throws IOException {
        //复制文件
        FileUtils.copyFile(new File("genji.jpg"),new File("copy.jpg"));
        //复制文件到目录
        FileUtils.copyFileToDirectory(new File("genji.jpg"), new File("lib"));
        //复制目录到目录,成为子目录
        FileUtils.copyDirectoryToDirectory(new File("lib"), new File("lib2"));
        //复制目录,将原文件的子文件复制到目标文件夹
        FileUtils.copyDirectory(new File("lib"), new File("lib2"));
        //拷贝URL内容
        String datas = IOUtils.toString(new URL("http://www.baidu.com"),"UTF-8");
        System.out.println(datas);
    }
}

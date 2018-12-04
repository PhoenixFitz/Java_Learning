package com.klaus.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * 统计大小
 */
public class CIOTest01 {
    public static void main(String[] args) throws IOException {
        //文件大小
        long len = FileUtils.sizeOf(new File("src/com/klaus/commons/CIOTest01.java"));
        System.out.println(len);
        //目录大小
        len = FileUtils.sizeOf(new File("C:/Users/hanbaozhen1/IdeaProjects"));
        System.out.println(len);
        test02();
        test03();
        test04();


    }

    /**
     * 遍历子孙集
     */
    public static void test02(){
       Collection<File> files = FileUtils.listFiles(new File("C:/Users/hanbaozhen1/IdeaProjects/IO_study02"),
               EmptyFileFilter.NOT_EMPTY, null);
       for(File file:files){
           System.out.println(file.getAbsolutePath());
       }
        System.out.println("------------------");
        files = FileUtils.listFiles(new File("C:/Users/hanbaozhen1/IdeaProjects/IO_study02"),
                EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);  //打印子孙文件
        for(File file:files){
            System.out.println(file.getAbsolutePath());
        }

        System.out.println("------------------");
        files = FileUtils.listFiles(new File("C:/Users/hanbaozhen1/IdeaProjects/IO_study02"),
                FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class")), DirectoryFileFilter.INSTANCE);
        for(File file:files){
            System.out.println(file.getAbsolutePath());
        }
    }

    /**
     * 读取内容
     */

    public static void test03() throws IOException {
        //读取文件
        String msg = FileUtils.readFileToString(new File("emp.txt"), "UTF-8");
        System.out.println(msg);
        byte[] datas = FileUtils.readFileToByteArray(new File("emp.txt"));
        System.out.println(datas.length);
        String ts = new String(datas);
        System.out.println(ts);
        System.out.println("--------------");
        //逐行读取
        List<String> list = FileUtils.readLines(new File("emp.txt"),"UTF-8");
        for(String string:list){
            System.out.println(string);
        }

        System.out.println("--------------");
        LineIterator it = FileUtils.lineIterator(new File("emp.txt"),"UTF-8");
        while(it.hasNext()){
            System.out.println(it.nextLine());
        }


    }

    /**
     * 写出内容
     */
    public static void test04() throws IOException {
        //写出文件
        FileUtils.write(new File("study.txt"), "writeByteArrayToFile:将字节数组内容写到文件中.\r\n", "UTF-8");
        FileUtils.writeStringToFile(new File("study.txt"), "writeLines：将容器中的元素的toString方法返回的内容依次写入文件中\r\n",
                "UTF-8",true);
        FileUtils.writeByteArrayToFile(new File("study.txt"), "writeStringToFile：将字符串内容写到文件中。\r\n".getBytes("UTF-8"),
                true);

        //写出列表
        List<String> datas = new ArrayList<String>();
        datas.add("Klaus");
        datas.add("Fitz");
        datas.add("Eleven");
        datas.add("女王");

        FileUtils.writeLines(new File("study.txt"), datas,"----",true);

    }


}


package com.klaus.io;

import java.io.*;

/**
 * 打印流 PrintStream
 */
public class PrintTest {

    public static void main(String[] args) throws FileNotFoundException {
        //打印流System.out
        PrintStream out = System.out;  //保存原始的输出流
        PrintStream ps = System.out;
        ps.println("打印流");
        ps.println(true);

        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")));
        ps.println("打印流~");
        ps.println(true);
        ps.flush();
        //重定向输出端
        System.setOut(ps);
        System.out.println("change");
        ps.flush();
        ps.close();
        //重定向回控制台、
        //System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out))));
        System.setOut(out);
        System.out.println("i am back");
        System.out.println("ssss");

    }
}

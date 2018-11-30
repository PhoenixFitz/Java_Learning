package com.klaus.io;
/**
 * 文件字符输入流  加入缓冲流
 */

import java.io.*;

public class BufferedTest02 {
    public static void main(String[] args){
        File src=new File("test.txt");
        BufferedReader reader=null;
        try {
            reader = new BufferedReader(new FileReader(src));
            //读取
            String line = null;
            while((line=reader.readLine())!=null){  //readLine(); 读取一行
                //字节数组-->字符串

                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(reader !=null) { //避免文件源未创建成功
                    //释放资源
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

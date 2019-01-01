package com.learn.loc;

import java.io.*;
import java.net.Socket;

/**
 * 上传文件
 * 创建客户端
 * 1、建立连接：使用Socket创建客户端+服务器的地址和端口
 * 2、操作：输入输出流操作
 * 3、释放资源
 */
public class FileClient {

    public static void main(String[] args) throws IOException {
        //建立连接：使用Socket创建客户端+服务器的地址和端口
        Socket client =new Socket("localhost",8888);
        //操作：文件拷贝  上传
        InputStream is = new BufferedInputStream(new FileInputStream("src/TCP基本步骤.png"));
        OutputStream os = new BufferedOutputStream(client.getOutputStream());
        byte[] flush = new byte[1024];
        int len = -1;
        while((len =is.read(flush))!=-1){
            os.write(flush, 0, len);
        }
        os.flush();
        //释放资源
        os.close();
        is.close();
        client.close();
    }
}

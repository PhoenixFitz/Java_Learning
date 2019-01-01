package com.learn.loc;
/**
 * 模拟登陆 双向传输
 */

import java.io.*;
import java.net.Socket;

public class LoginTwoWayClient {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String uname = console.readLine();
        System.out.println("请输入密码：");
        String upwd = console.readLine();
        //建立连接：使用Socket创建客户端+服务器的地址和端口
        Socket client =new Socket("localhost",8888);
        //操作：输入输出流操作
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("uname="+uname+"&"+"upwd="+upwd);
        dos.flush();

        DataInputStream dis =new DataInputStream(client.getInputStream());
        String result = dis.readUTF();
        System.out.println(result);
        //释放资源
        dos.close();
        client.close();
    }
}

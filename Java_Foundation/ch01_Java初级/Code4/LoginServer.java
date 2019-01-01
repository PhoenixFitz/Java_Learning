package com.learn.loc;
/**
 * 模拟登陆 单项传输
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) throws IOException {
        //指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //阻塞式等待连接accept
        Socket client = server.accept();
        System.out.println("一个客户端建立连接");
        //操作：输入输出流操作
        DataInputStream dis =new DataInputStream(client.getInputStream());
        String datas = dis.readUTF();
        //分析数据
        String[] dataArray = datas.split("&");
        for(String info:dataArray){
            String[] userInfo = info.split("=");
            if(userInfo[0].equals("uname")){
                System.out.println("你的用户名为:"+userInfo[1]);
            }else if(userInfo[0].equals("upwd")){
                System.out.println("你的密码为:"+userInfo[1]);
            }
        }

        //释放资源
        dis.close();
        client.close();
    }
}

package chat.test;

import java.io.*;
import java.net.Socket;

/**
 * 在线聊天室：客户端
 * 封装多线程实现多个客户可以正常收发多条消息
 */
public class TMultiClientX {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Client-----");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名:");
        String name = br.readLine();
        //建立连接：使用Socket创建客户端+服务器的地址和端口
        Socket client =new Socket("localhost",8888);
        //客户端发送消息
        new Thread(new Send(client,name)).start();
        new Thread(new Receive(client)).start();
    }
}

package chat.test;

import java.io.*;
import java.net.Socket;

/**
 * 在线聊天室：客户端  使用多线程实现多人收发多条消息
 */
public class MultiClientX {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Client-----");
        //建立连接：使用Socket创建客户端+服务器的地址和端口
        Socket client =new Socket("localhost",8888);
        //客户端发送消息
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        boolean isRunning = true;
        while(isRunning) {
            String msg = console.readLine();

            dos.writeUTF(msg);
            dos.flush();
            //获取消息

            msg = dis.readUTF();
            System.out.println(msg);
        }
        //释放资源
        dos.close();
        dis.close();
        client.close();
    }
}

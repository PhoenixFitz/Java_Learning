package chat.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：服务器  使用多线程实现多人收发多条消息
 */
public class MultiChat {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-----");
        //指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //阻塞式等待连接accept
        while(true) {
            Socket client = server.accept();
            System.out.println("一个客户端建立连接");
            new Thread(()->{
                DataInputStream dis = null;
                DataOutputStream dos = null;
                try {
                    dis = new DataInputStream(client.getInputStream());
                    dos = new DataOutputStream(client.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                boolean isRunning = true;
                while (isRunning) {
                    //接收消息
                    String msg = null;
                    try {
                        msg = dis.readUTF();
                        //返回消息
                        dos.writeUTF(msg);
                        dos.flush();
                    } catch (IOException e) {
                        //e.printStackTrace();
                        isRunning = false;  //停止线程
                    }

                }
                //释放资源
                try {
                    if(dos!=null) {
                        dos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if(dis!=null) {
                        dis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if(client!=null) {
                        client.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        }

    }

}

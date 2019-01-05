package chat.test;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 使用多线程封装接收端
 */
public class Receive implements Runnable {
    private DataInputStream dis;
    private Socket client;
    private boolean isRunning;
    public Receive(Socket client){
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
            isRunning = true;
        } catch (IOException e) {
            System.out.println("client error");
            release();
        }
    }
    @Override
    public void run() {
        while(isRunning){
            String msg = receive();
            if(!msg.equals("")){
                System.out.println(msg);
            }
        }
    }


    //接收消息
    private String receive(){
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            System.out.println("client receive error");
            release();
        }
        return msg;
    }

    //释放资源
    private void release(){
        this.isRunning = false;
        ChatUtils.close(dis,client);
    }
}

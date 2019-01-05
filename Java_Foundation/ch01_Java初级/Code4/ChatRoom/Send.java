package chat.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 使用多线程封装发送端
 *
 */
public class Send implements Runnable {
    private BufferedReader console;
    private DataOutputStream dos;
    private Socket client;
    private boolean isRunning;
    private String name;
    public Send(Socket client,String name){
        this.name = name;
        this.client = client;
        console = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(client.getOutputStream());
            isRunning = true;
            //发送名称
            send(name);
        } catch (IOException e) {
            System.out.println("client error");
            this.release();
        }
    }
    @Override
    public void run() {
        while(isRunning){
            String msg = getStrFromConsole();
            if(!msg.equals("")){
                send(msg);
            }
        }

    }
    //从控制台获取消息
    private String getStrFromConsole(){
        try {
            return console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    //发送消息
    private void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            System.out.println("client send error");
            release();
        }
    }

    //释放资源
    private void release(){
        this.isRunning = false;
        ChatUtils.close(dos,client);
    }
}

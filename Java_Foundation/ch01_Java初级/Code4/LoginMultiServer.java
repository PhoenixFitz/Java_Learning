package com.learn.loc;
/**
 * 模拟登陆 多个客户端请求
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginMultiServer {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-----");
        //指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        boolean isRunning = true;
        //阻塞式等待连接accept
        while(isRunning) {
            Socket client = server.accept();
            System.out.println("一个客户端建立连接");
            new Thread(new Channel(client)).start();
        }
    }
    //一个Channel 代表一个客户端
    static class Channel implements Runnable{
        private  Socket client;
        //输入流
        private DataInputStream dis;
        //输出流
        private DataOutputStream dos;
        //构造器
        public Channel(Socket client){
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
            //输出

        }

        //接收数据
        private String receive(){
            String datas = "";
            try {
                datas = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return datas;
        }

        //发送数据
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //释放资源
        private void release(){
            try {
                if(dos!=null){
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
        }

        @Override
        public void run() {
            //操作：输入输出流操作

            String uname = "";
            String upwd = "";
            //分析数据
            String[] dataArray = receive().split("&");
            for (String info : dataArray) {
                String[] userInfo = info.split("=");
                if (userInfo[0].equals("uname")) {
                    System.out.println("你的用户名为:" + userInfo[1]);
                    uname = userInfo[1];
                } else if (userInfo[0].equals("upwd")) {
                    System.out.println("你的密码为:" + userInfo[1]);
                    upwd = userInfo[1];
                }
            }

            if (uname.equals("Niklaus") && upwd.equals("Snow")) { //成功
                send("登陆成功，欢迎回来");
            } else {//失败
                send("用户名或密码错误");
            }
            //释放资源
            release();
        }


    }


}

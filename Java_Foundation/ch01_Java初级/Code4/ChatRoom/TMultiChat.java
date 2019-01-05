package chat.test;
/**
 * 在线聊天  服务器
 * 封装多线程实现多个客户可以正常收发多条消息
 * 加入容器实现群聊 私聊
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class TMultiChat {
    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-----");
        //指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        boolean isRunning = true;
        //阻塞式等待连接accept
        while(isRunning) {
            Socket client = server.accept();
            System.out.println("一个客户端建立连接");
            Channel c = new Channel(client);
            all.add(c);//管理所有成员
            new Thread(c).start();
        }
    }
    //一个Channel 代表一个客户端
    static class Channel implements Runnable{
        private  Socket client;
        //输入流
        private DataInputStream dis;
        //输出流
        private DataOutputStream dos;
        private boolean isRunning;
        private String name;
        //构造器
        public Channel(Socket client){
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                isRunning = true;
                //获取名称
                this.name = receive();
                //欢迎您的到来
                this.send("欢迎您的到来!");
                sendOthers(this.name+"来到了聊天室",true);
            } catch (IOException e) {
                System.out.println("created in error");
                release();
            }
            //输出

        }

        //接收消息
        private String receive(){
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                System.out.println("receive error");
                release();
            }
            return msg;
        }

        //发送消息
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                System.out.println("send error");
                release();
            }
        }

        //群聊  获取自己的消息 发给其他人
        //私聊  约定数据格式：@xxx：msg
        private void sendOthers(String msg,boolean flag){
            boolean isPrivate = msg.startsWith("@");
            if(isPrivate){//私聊
                int idx = msg.indexOf(":");
                //获取目标和数据
                String targetName = msg.substring(1,idx);
                msg = msg.substring(idx+1);
                for(Channel other:all){
                    if(other.name.equals(targetName)) {
                        other.send(this.name + "悄悄地对您说："+msg);
                        break;
                    }
                }

            }else {//群聊
                for (Channel others : all) {
                    if (others == this) {
                        continue;
                    }
                    if (flag == false) {
                        others.send(this.name + "对所有人说：" + msg);//群聊消息
                    } else {
                        others.send(msg); //系统消息
                    }

                }
            }
        }

        //释放资源
        private void release(){
            this.isRunning = false;
            ChatUtils.close(dis,dos,client);
            //退出
            all.remove(this);
            sendOthers(this.name+"离开了聊天室...", true);
        }

        @Override
        public void run() {
            while(isRunning){
                String msg = receive();
                if(!msg.equals("")){
                    sendOthers(msg,false);
                }
            }
        }


    }


}

package com.learn.loc;

/**
 * 加入多线程，实现双向甲流，模拟在线咨询
 */
public class TalkTeacher {
    public static void main(String[] args){
        new Thread(new TalkReceive(9999,"student")).start(); //接收
        new Thread(new TalkSend(6666,"localhost",8888)).start();//发送
    }
}

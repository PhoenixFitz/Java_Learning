package com.learn.loc;

/**
 * 加入多线程，实现双向甲流，模拟在线咨询
 */
public class TalkStudent {
    public static void main(String[] args){
        new Thread(new TalkSend(7777,"localhost",9999)).start();//发送
        new Thread(new TalkReceive(8888,"teacher")).start(); //接收
    }
}

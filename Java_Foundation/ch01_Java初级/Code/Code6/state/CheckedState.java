package com.klaus.state;
// 入住状态
public class CheckedState implements State{
    @Override
    public void handle() {
        System.out.println("房间已有人入住");
    }
}

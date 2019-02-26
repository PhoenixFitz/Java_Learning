package com.klaus.adapter;

/**
 * 类适配器方式
 * 适配器（相当于USB和ps/2的转换器
 */
public class Adapter extends Adaptee implements Target{



    @Override
    public void handleReq() {
        super.request();
    }
}

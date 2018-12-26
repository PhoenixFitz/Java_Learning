package com.learn.loc;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL 统一资源定位器 ，区分资源
 * 协议、域名或计算机名、端口（默认80）、请求资源
 */
public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url =new URL("http://www.baidu.con:80/index.html#aa?cansu=bjsxt");
        //获取四个值
        System.out.println("协议："+url.getProtocol());
        System.out.println("域名|IP："+url.getHost());
        System.out.println("端口："+url.getPort());
        System.out.println("请求资源1："+url.getFile());
        System.out.println("请求资源2："+url.getPath());

        //获取参数
        System.out.println("参数："+url.getQuery());
        //锚点
        System.out.println("锚点:"+url.getRef());
    }
}

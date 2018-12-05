package com.klaus.thread;

public class TDownloader extends Thread{

    private String url;  //远程路径
    private String name;    //存储名字

    public TDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.download(url, name);
        System.out.println(name);
    }


       public static void main(String[] args){
           TDownloader td1 =new TDownloader("https://i.postimg.cc/vZH1xvB0/image.png", "包装类.png");
           TDownloader td2 =new TDownloader("https://i.postimg.cc/wMdPQFnR/image.png", "日期相关类.png");
           TDownloader td3 =new TDownloader("https://i.postimg.cc/sXZwkvZw/image.png","文件创建.png" );
           //启动三个线程
           td1.start();
           td2.start();
           td3.start();
        }

}

package com.klaus.thread;
import java.util.concurrent.*;

public class CDownloader implements Callable<Boolean> {

    private String url;  //远程路径
    private String name;    //存储名字

    public CDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception{
        WebDownloader wd = new WebDownloader();
        wd.download(url, name);
        System.out.println(name);
        return true;
    }


       public static void main(String[] args) throws ExecutionException, InterruptedException {
           CDownloader cd1 =new CDownloader("https://i.postimg.cc/vZH1xvB0/image.png", "包装类.png");
           CDownloader cd2 =new CDownloader("https://i.postimg.cc/wMdPQFnR/image.png", "日期相关类.png");
           CDownloader cd3 =new CDownloader("https://i.postimg.cc/sXZwkvZw/image.png","文件创建.png" );

           //创建执行服务
           ExecutorService ser = Executors.newFixedThreadPool(3);
           //提交执行
           Future<Boolean> result1 = ser.submit(cd1);
           Future<Boolean> result2 = ser.submit(cd2);
           Future<Boolean> result3 = ser.submit(cd3);

           //获取结果
           boolean r1 = result1.get();
           boolean r2 = result2.get();
           boolean r3 = result3.get();
           //关闭服务
           ser.shutdownNow();




        }

}

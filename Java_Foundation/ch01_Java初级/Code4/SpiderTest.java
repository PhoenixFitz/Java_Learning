package com.learn.loc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SpiderTest {

    public static void main(String[] args) throws IOException {
        //获取URL
        URL url = new URL("http://www.jd.com");
        //下载资源
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        String msg = null;
        while((msg=br.readLine())!=null){
            System.out.println(msg);

        }
        br.close();

        URL url2 =new URL("https://www.dianping.com");
        HttpURLConnection conn =(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
        br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        while((msg=br.readLine())!=null){
            System.out.println(msg);

        }
    }
}

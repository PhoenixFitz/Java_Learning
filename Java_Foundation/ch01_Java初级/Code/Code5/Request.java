package klaus.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 封装请求协议：获取method uri 以及请求参数
 */
public class Request {
    private String requestInfo;
    private String method; //请求方式
    private String url;
    private String queryStr; // 请求参数
    private final  String CRLF = "\r\n";
    public Request(InputStream is ){
        //获取请求协议
        byte[] datas = new byte[1024*1024];
        int len = 0;
        try {
            len = is.read(datas);
            this.requestInfo = new String(datas,0,len);
            System.out.println(requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //分解字符串
        parseRequestInfo();
    }
    private void parseRequestInfo(){
        System.out.println("-----分解------");
        System.out.println("----1.获取请求方式：开头到第一个/-----");
        this.method = this.requestInfo.substring(0,this.requestInfo.indexOf("/")).toLowerCase();
        this.method=this.method.trim();
        System.out.println(method);
        System.out.println("----2.获取请求url：第一个/到HTTP/-----");
        System.out.println("----可能包含请求参数，？前面的为url------");
        //1)获取/的位置
        int startldx = this.requestInfo.indexOf("/")+1;
        //2)获取HTTP/的位置
        int endldx = this.requestInfo.indexOf("HTTP/");
        //3)分割字符串
        this.url = this.requestInfo.substring(startldx,endldx);

        //4)获取?的位置
        int queryIdx = this.url.indexOf("?");
        if(queryIdx>=0){//表示请求参数存在
            String[] urlArray = this.url.split("\\?");
            this.url = urlArray[0];
            queryStr = urlArray[1];
        }
        System.out.println(this.url);

        System.out.println("----3.获取请求参数:如果是Get已经获取，如果是post可能再请求体中----");

        if(method.equals("post")){
            String qStr = this.requestInfo.substring(this.requestInfo.lastIndexOf(CRLF)).trim();
            if(queryStr == null) {
                queryStr = qStr;
            }else {
                queryStr += "&"+ qStr;
            }
        }
        queryStr = null==queryStr?"":queryStr;
        System.out.println(method+"--->"+url+"--->"+queryStr);

    }
    public Request(Socket client) throws IOException {
        this(client.getInputStream());
    }
}

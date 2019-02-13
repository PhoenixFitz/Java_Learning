package klaus.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

/**
 * 封装请求协议：封装请求参数为Map
 */
public class Request02 {
    private String requestInfo;
    private String method; //请求方式
    private String url;
    private String queryStr; // 请求参数
    private Map<String, List<String>> parameterMap;//存储参数
    private final  String CRLF = "\r\n";
    public Request02(InputStream is ){
        parameterMap = new HashMap<String,List<String>>();
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
        //转成Map  fav=1&fav=2&uname=shsxt&age=18&others=
        convertMap();
    }

    //处理请求参数为Map
    private void convertMap(){
        //分割字符串 &
        String[] keyValues = this.queryStr.split("&");
        for(String queryStr:keyValues){
            //再次分割字符串 =
            String[] kv =queryStr.split("=");
            kv = Arrays.copyOf(kv,2);
            //获取key和value
            String key = kv[0];
            String value = kv[1]==null?null:decode(kv[1],"utf-8");
            //存储到Map中
            if(!parameterMap.containsKey(key)){ //第一次
                parameterMap.put(key,new ArrayList<String>());
            }
            parameterMap.get(key).add(value);
        }
    }
    //处理中文
    private String decode(String value,String enc) {
        try {
            return java.net.URLDecoder.decode(value, enc);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    //通过name获取对应的多个值
    public String[] getParametrValues(String key){
        List<String> values = this.parameterMap.get(key);
        if(values==null||values.size()<1){
            return null;
        }
        return values.toArray(new String[0]);
    }
    //通过name获取对应的1个值
    public String getParameter(String key){
        String[] values = getParametrValues(key);
        return values == null?null:values[0];
    }
    public Request02(Socket client) throws IOException {
        this(client.getInputStream());
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getQueryStr() {
        return queryStr;
    }

}

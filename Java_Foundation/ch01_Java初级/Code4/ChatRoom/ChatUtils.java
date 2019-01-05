package chat.test;

import java.io.Closeable;

/**
 * 工具类
 *
 */
public class ChatUtils {

    /**
     * 释放资源
     */
    public static void close(Closeable... targets){
        for(Closeable target:targets){
            try{
                if(null!=target){
                    target.close();
                }
            }catch (Exception e){

            }
        }
    }
}

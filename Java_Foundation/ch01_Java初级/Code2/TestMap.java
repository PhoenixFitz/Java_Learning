

import java.util.HashMap;
import java.util.Map;

/**
 * 测试HashMap的使用
 *
 */
public class TestMap {

    public static void main(String[] args){

        Map<Integer,String> m1= new HashMap<>();
        m1.put(1, "one");
        m1.put(2, "two");
        m1.put(3, "three");
        m1.put(4, "four");

        System.out.println(m1.get(1));

        System.out.println(m1.size());
        System.out.println(m1.isEmpty());
        System.out.println(m1.containsKey(2));
        System.out.println(m1.containsValue("five"));
        System.out.println(m1);
        Map<Integer,String> m2=new HashMap<>();
        m2.put(6, "six");
        m2.put(7, "seven");
        m1.putAll(m2);
        System.out.println(m1);
        //map中的键是不能重复的，如果重复（是否重复是根据equals方法来判断的），则新的会覆盖旧的
        m1.put(3, "三");
        System.out.println(m1);

    }
}

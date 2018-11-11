

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 测试Collection接口中的方法
 */
public class TestList {
    public static void main(String[] args){
        test02();
    }


    public static void test01(){
        Collection<String> c =new ArrayList<>();


        System.out.println(c.size());
        System.out.println(c.isEmpty());
        c.add("Klaus");
        c.add("Niklaus");
        System.out.println(c);
        System.out.println(c.size());
        System.out.println(c.contains("Klaus"));

        Object[] objs=c.toArray();   //转化一个Object数组
        System.out.println(objs);

        c.remove("Klaus");
        System.out.println(c);

        c.clear();
        System.out.println(c);


    }


    public static void test02(){

        List<String>  list01 = new ArrayList<>();
        list01.add("aa");
        list01.add("bb");
        list01.add("cc");

        List<String> list02 =new ArrayList<>();
        list02.add("aa");
        list02.add("dd");
        list02.add("ee");

        System.out.println("list01:"+list01);
        list01.addAll(list02);     //将list02中的所有元素加到list01中
        // list01.removeAll(list02);  //移除交集元素
        // list01.retainAll(list02);    //移除非交集元素
        System.out.println("list01:"+list01);

        System.out.println(list01.containsAll(list02));   //判断list01中是否包含list02中的所有元素

    }
}

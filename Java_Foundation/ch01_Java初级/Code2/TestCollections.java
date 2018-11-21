package klaus.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections辅助类的使用
 * Collection是接口，Collections是工具类
 */
public class TestCollections {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add("Klaus:"+i);
        }
        System.out.println(list);

        Collections.shuffle(list);  //随机排列list中的元素
        System.out.println(list);

        Collections.reverse(list);  //逆序排列
        System.out.println(list);

        Collections.sort(list);    //按照递增方式排列，自定义类的使用：Comparable接口
        System.out.println(list);

        System.out.println(Collections.binarySearch(list, "fitz")); //对于顺序的List容器，采用折半查找的方法查找特定对象

    }
}

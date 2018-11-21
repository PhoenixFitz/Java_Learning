package klaus.test;

import java.util.*;

/**
 * 测试迭代器遍历List、Set、Map
 */
public class TestIterator {

    public static void main(String[] args){
        testIteratorList();
        testIteratorSet();
        testIteratorMap();
    }

    public static void testIteratorList(){
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");
        //使用iterator遍历List
        for(Iterator<String> iter=list.iterator();iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }


    }

    public static void testIteratorSet(){
        Set<String> set = new HashSet<>();
        set.add("aaa");
        set.add("dddd");
        set.add("gffff");
        //使用iterator遍历Set
        for(Iterator<String> iter=set.iterator();iter.hasNext();){
            String temp = iter.next(); //获得当前元素
            System.out.println(temp);
        }


    }

    public static void testIteratorMap(){
        Map<Integer,String> map1=new HashMap<>();
        map1.put(100, "klaus");
        map1.put(200, "Fitz");
        map1.put(300, "Sky");

        Set<Map.Entry<Integer,String>> ss=map1.entrySet();
        //第一种方法：使用iterator遍历Map
        for(Iterator<Map.Entry<Integer,String>> iter = ss.iterator(); iter.hasNext();){
            Map.Entry<Integer,String> temp=iter.next();
            System.out.println(temp.getKey()+"--"+temp.getValue());
        }
        System.out.println("##############");
        //第二种方法：使用Iterator遍历Map
        Set<Integer> keySet=map1.keySet();
        for(Iterator<Integer> iter=keySet.iterator();iter.hasNext();){
            Integer key=iter.next();
            System.out.println(key+"--"+map1.get(key));
        }


    }
}

package klaus.test;

import java.util.*;

/**
 * 测试表格数据存储
 * ORM思想简单实验：Map表示一行数据，多行数据用多个Map，将多个Map放到List中
 */
public class TestStoreData {

    public static <set> void main(String[] args){
        Map<String,Object> row1=new HashMap<>();
        row1.put("id", 1001);
        row1.put("name", "Klaus");
        row1.put("salary", 20000);
        row1.put("Entry time", "2018.1.1");

        Map<String,Object> row2=new HashMap<>();
        row2.put("id", 1002);
        row2.put("name", "Fitz");
        row2.put("salary", 30000);
        row2.put("Entry time", "2013.1.1");

        Map<String,Object> row3=new HashMap<>();
        row3.put("id", 1003);
        row3.put("name", "Snow");
        row3.put("salary", 8000);
        row3.put("Entry time", "2018.8.1");

        List<Map<String,Object>> table1=new ArrayList<>();
        table1.add(row1);
        table1.add(row2);
        table1.add(row3);

      //打印表的内容
      for(Map<String,Object> row:table1){
            Set<String> keySet=row.keySet();
            for(String key:keySet){
                System.out.print(key+":"+row.get(key)+"\t");
            }
            System.out.println();
        }

      /*
      //用迭代器打印表的内容。
      for(Map<String,Object> row:table1){
            Set<String> keySet=row.keySet();
            for(Iterator<String> iter = keySet.iterator();iter.hasNext();){
                Object temp=iter.next();
                System.out.print(temp+":"+row.get(temp)+"\t");
            }
            System.out.println();
        }
      */
      /*
      //用第二种迭代器遍历的方法打印表内容
      for(Map<String,Object> row:table1){
          Set<Map.Entry<String,Object>> entrySet=row.entrySet();
          for(Iterator<Map.Entry<String,Object>> iter=entrySet.iterator();iter.hasNext();){
              Map.Entry<String,Object> temp=iter.next();
              System.out.print(temp.getKey()+":"+temp.getValue()+"\t");
          }
          System.out.println();
      }
      */
    }

}

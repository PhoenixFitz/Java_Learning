package klaus.test;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {
    public static void main(String[] args){
        Map<Integer,String> treemap1=new TreeMap<>();
        treemap1.put(20, "aa");
        treemap1.put(3, "bb");
        treemap1.put(6, "cc");

        //按照key递增的方式排序
        for(Integer key:treemap1.keySet()){
            System.out.println(key+"---"+treemap1.get(key));
        }

        Map<Emp,String> treemap2=new TreeMap<>();
        treemap2.put(new Emp(100, "Klaus", 50000), "Vampire");
        treemap2.put(new Emp(200, "Fitz", 100000), "Scientist");
        treemap2.put(new Emp(300, "Snow", 80000), "Knight");
        treemap2.put(new Emp(400, "Elia", 80000), "Hunter");

        for(Emp key:treemap2.keySet()){
            System.out.println(key+"---"+treemap2.get(key));
        }

    }
}


class Emp implements Comparable<Emp>{
    int id;
    String name;
    double salary;

    public Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id:"+id+",name:"+name+",salary:"+salary;
    }

    @Override
    public int compareTo(@NotNull Emp o) {  //负数-小于 ，0-等于 ，正数-大于

        if(this.salary>o.salary){
            return 1;
        }else if(this.salary<o.salary){
            return -1;
        }else{
            if(this.id>o.id){
                return 1;
            }else if(this.id<o.id){
                return -1;
            }else {
                return 0;
            }
        }
    }
}
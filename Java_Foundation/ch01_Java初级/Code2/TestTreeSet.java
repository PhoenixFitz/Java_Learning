package klaus.test;

import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args){
        Set<Integer> set = new TreeSet<>();
        set.add(300);
        set.add(6090);
        set.add(1200);
        set.add(10);
        //按照元素递增的方式排序
        for(Integer m:set){
            System.out.println(m);
        }

        Set<Emp2> set2=new TreeSet<>();
        set2.add(new Emp2(100,"Klaus",5000));
        set2.add(new Emp2(500,"NiKlaus",8000));
        set2.add(new Emp2(200,"Fitz",2000));
        set2.add(new Emp2(300,"Sky",10000));

        for(Emp2 sm:set2){
            System.out.println(sm);
        }
    }
}

class Emp2 implements Comparable<Emp2>{
    int id;
    String name;
    double salary;

    public Emp2(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id:"+id+",name:"+name+",salary:"+salary;
    }

    @Override
    public int compareTo(Emp2 o) {  //负数-小于 ，0-等于 ，正数-大于

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

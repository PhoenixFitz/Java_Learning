package klaus.test;

import java.util.*;

/**
 * 测试表格数据的存储，每一行数据使用javabean对象，多行使用并放到Map或List中
 */
public class TestStoreData2 {

    public static void main(String[] args){
        User user1=new User(1001, "Klaus", 20000, "2018.1.1");
        User user2=new User(1002, "Fitz", 30000, "2013.1.1");
        User user3=new User(1003, "Snow", 8000, "2018.8.1");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        for(User u:list){
            System.out.println(u);;
        }

        Map<Integer,User> map = new HashMap<>();
        map.put(user1.getId(), user1);
        map.put(user2.getId(), user2);
        map.put(user3.getId(), user3);

        Set<Integer> keyset=map.keySet();
        for(Integer key:keyset){
            System.out.println(key+"---"+map.get(key));
        }
    }
}


class User{
    private int id;
    private String name;
    private double salary;
    private String hiredata;

    //一个完整的javabean，要有set和get方法以及无参构造器
    public User(){

    }

    public User(int id, String name, double salary, String hiredata) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.hiredata = hiredata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHiredata() {
        return hiredata;
    }

    public void setHiredata(String hiredata) {
        this.hiredata = hiredata;
    }

    @Override
    public String toString() {
        return "id;"+id+" name:"+name+" salary:"+salary+" hiredate:"+hiredata;
    }
}
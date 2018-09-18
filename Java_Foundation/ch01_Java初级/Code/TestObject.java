//toString()方法测试和重写toString()方法

class Person {
    String name;
    int age;
    @Override
    public String toString() {
        return name+",年龄："+age;
    }
}
public class TestObject {
    public static void main(String[] args) {
        Person p=new Person();
        p.age=20;
        p.name="李东";
        System.out.println("info:"+p);
         
        Test t = new Test();
        System.out.println(t);
    }
}
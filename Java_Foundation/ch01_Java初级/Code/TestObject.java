//toString()�������Ժ���дtoString()����

class Person {
    String name;
    int age;
    @Override
    public String toString() {
        return name+",���䣺"+age;
    }
}
public class TestObject {
    public static void main(String[] args) {
        Person p=new Person();
        p.age=20;
        p.name="�";
        System.out.println("info:"+p);
         
        Test t = new Test();
        System.out.println(t);
    }
}
class Person {
    private String name;
    private int age;
    public Person() {
 
    }
    public Person(String name, int age) {
        this.name = name;
        // this.age = age;/*因为setAge方法中有条件判断，因此构造方法中不能直接赋值，应该调用setAge方法*/
        setAge(age);
    }
     
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        //在赋值之前先判断年龄是否合法
        if (age > 130 || age < 0) {
            this.age = 18;//不合法赋默认值18
        } else {
            this.age = age;//合法才能赋值给属性age
        }
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
 
public class TestEncapsulation4 {
    public static void main(String[] args) {
        Person p1 = new Person();
        //p1.name = "小红"; //编译错误
        //p1.age = -45;  //编译错误
        p1.setName("小红");
        p1.setAge(-45);
        System.out.println(p1);
         
        Person p2 = new Person("小白", 300);
        System.out.println(p2);
    }
}
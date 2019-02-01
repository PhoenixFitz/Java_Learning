class Person {
    private String name;
    private int age;
    public Person() {
 
    }
    public Person(String name, int age) {
        this.name = name;
        // this.age = age;/*��ΪsetAge�������������жϣ���˹��췽���в���ֱ�Ӹ�ֵ��Ӧ�õ���setAge����*/
        setAge(age);
    }
     
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        //�ڸ�ֵ֮ǰ���ж������Ƿ�Ϸ�
        if (age > 130 || age < 0) {
            this.age = 18;//���Ϸ���Ĭ��ֵ18
        } else {
            this.age = age;//�Ϸ����ܸ�ֵ������age
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
        //p1.name = "С��"; //�������
        //p1.age = -45;  //�������
        p1.setName("С��");
        p1.setAge(-45);
        System.out.println(p1);
         
        Person p2 = new Person("С��", 300);
        System.out.println(p2);
    }
}
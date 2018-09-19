public class TestEquals { 
    public static void main(String[] args) {
        Person p1 = new Person(123,"���");
        Person p2 = new Person(123,"��С��");     
        System.out.println(p1==p2);     //false������ͬһ������
        System.out.println(p1.equals(p2));  //true��id��ͬ����Ϊ��������������ͬ
        String s1 = new String("��ѧ��");
        String s2 = new String("��ѧ��");
        System.out.println(s1==s2);         //false, �����ַ�������ͬһ������
        System.out.println(s1.equals(s2));  //true,  �����ַ���������ͬ
    }
}
class Person {
    int id;
    String name;
    public Person(int id,String name) {
        this.id=id;
        this.name=name;
    }
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }else {
            if(obj instanceof Person) {
                Person c = (Person)obj;
                if(c.id==this.id) {
                    return true;
                }
            }
        }
        return false;
    }
}
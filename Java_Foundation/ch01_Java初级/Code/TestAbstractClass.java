//������
abstract class Animal {
    abstract public void shout();  //���󷽷���û�з����壬ֻ������
}
class Dog extends Animal { 
    //�������ʵ�ָ���ĳ��󷽷�������������
    public void shout() {
        System.out.println("��������");
    }
    public void seeDoor(){
        System.out.println("������....");
    }
}
//���Գ�����
public class TestAbstractClass {
    public static void main(String[] args) {
        Dog a = new Dog();
	Animal b = new Dog(); //���Դ���
      //Animal c = new Animal(); // ������󣬲�����new��ʵ���������ࡣ
        a.shout();
        a.seeDoor();
    }
}
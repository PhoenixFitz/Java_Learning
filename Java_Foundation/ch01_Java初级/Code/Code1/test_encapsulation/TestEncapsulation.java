package test_encapsulation;


/**
 * ���Է�װ
 * @author wakl2
 *
 */
public class TestEncapsulation {
	public static void main(String[] args) {
		Human h=new Human();
//		h.age=13;    //ֻ����Human���ڷ���
		h.name="klaus";  //Ĭ��������ͬһ�����ڵ�����Է���
		
		Person p=new Person();
	//	p.name="sd";   //private
		p.age=18;
		p.height=183;
		p.weight=140;
		
	}

}


class Human{
	private int age;
	String name;   //Ĭ��
	
	void sayAge() {
		System.out.println(age);
	}
}

class Boy extends Human{
	void sayHello() {
//		System.out.println(age);      // �����޷�ʹ�ø����˽�����Ժͷ���
	
	}
}
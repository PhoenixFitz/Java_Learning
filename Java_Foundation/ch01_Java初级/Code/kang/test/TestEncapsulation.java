package kang.test;

import test_encapsulation.Person;


public class TestEncapsulation {
	public static void main(String[] args) {
//		Human h=new Human();  //Ĭ������ͬһ�����п���ʹ�ã���ͬ���ǲ��ܷ��ʵ�
		Person p=new Person();
//		p.name="klaus";  //nameΪdefault�ؼ��ֵ����ԣ�ֻ���Ա��������ı�������������
		p.height=183;
//		p.weight=140;  //��ͬ���Ҳ���Person���࣬���ܷ���
		
		
	}

}


class Girl extends Person{
	void sayGood() {
		System.out.println(height);  //��ͬ��������������Է���
	}
}

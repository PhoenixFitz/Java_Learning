//package kang.test;
/**
 * ���Լ̳�
 * @author wakl2
 *
 */

public class TestExtends {
	public static void main(String[] args) {
		Student s=new Student("Klaus",178,"Java");
		s.rest();
		s.study();
		//ʹ��instanceof��������������ж�
		System.out.println(s instanceof Student);
		System.out.println(s instanceof Person); 
	}
}

class Person /*extends Object*/{
	String name;
	int height;
	public void rest() {
		System.out.println("Having a rest!");
	}
}

class Student extends Person{//�̳и����ȫ�����Ժͷ��������˸���Ĺ��췽����
	String major;
	public void study() {
		System.out.println("I'm studying!");
	}
	public Student(String name,int height,String major) { //��Ȼӵ�и��׵�����
		this.name=name;
		this.height=height;
		this.major=major;
	}
}
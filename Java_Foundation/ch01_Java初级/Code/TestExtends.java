//package kang.test;
/**
 * 测试继承
 * @author wakl2
 *
 */

public class TestExtends {
	public static void main(String[] args) {
		Student s=new Student("Klaus",178,"Java");
		s.rest();
		s.study();
		//使用instanceof运算符进行类型判断
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

class Student extends Person{//继承父类的全部属性和方法（除了父类的构造方法）
	String major;
	public void study() {
		System.out.println("I'm studying!");
	}
	public Student(String name,int height,String major) { //天然拥有父亲的属性
		this.name=name;
		this.height=height;
		this.major=major;
	}
}
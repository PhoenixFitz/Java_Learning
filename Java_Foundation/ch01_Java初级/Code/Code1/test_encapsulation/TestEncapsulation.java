package test_encapsulation;


/**
 * 测试封装
 * @author wakl2
 *
 */
public class TestEncapsulation {
	public static void main(String[] args) {
		Human h=new Human();
//		h.age=13;    //只能由Human类内访问
		h.name="klaus";  //默认属性在同一个包内的类可以访问
		
		Person p=new Person();
	//	p.name="sd";   //private
		p.age=18;
		p.height=183;
		p.weight=140;
		
	}

}


class Human{
	private int age;
	String name;   //默认
	
	void sayAge() {
		System.out.println(age);
	}
}

class Boy extends Human{
	void sayHello() {
//		System.out.println(age);      // 子类无法使用父类的私有属性和方法
	
	}
}
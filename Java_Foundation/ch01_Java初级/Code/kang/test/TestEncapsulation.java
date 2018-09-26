package kang.test;

import test_encapsulation.Person;


public class TestEncapsulation {
	public static void main(String[] args) {
//		Human h=new Human();  //默认类在同一个包中可以使用，不同包是不能访问的
		Person p=new Person();
//		p.name="klaus";  //name为default关键字的属性，只可以被它所属的本包下面的类访问
		p.height=183;
//		p.weight=140;  //不同包且不是Person子类，不能访问
		
		
	}

}


class Girl extends Person{
	void sayGood() {
		System.out.println(weight);  //不同包的其他子类可以访问
	}
}

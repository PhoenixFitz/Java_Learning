package test_encapsulation;

public class Person {
	private String name;
	int age;      //没有public关键字的属性，只可以被本包下面的类访问
	public int height;  // 可以被该项目下的其他包访问
	protected int weight;
}

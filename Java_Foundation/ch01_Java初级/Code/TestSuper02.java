

public class TestSuper02 {
	public static void main(String[] args) {
		System.out.println("开始创建一个ChildClass对象。。。。");
		new ChildClass2();   //new子类时，会调用父类的无参数构造方法。
	}
}

class FatherClass2{
	public FatherClass2() {
		
	super();
	System.out.println("创建FatherClass");
	}
}

class ChildClass2 extends FatherClass2{
	public ChildClass2() {
		super();    //super()若不显示调用，java默认会调用super()，含义是调用父类的无参数构造方法。
		System.out.println("创建ChildaClass");
	}
}



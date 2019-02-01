class Computer{
	String brand;
}

public class SxtStu {


	
	// 属性fields
	int id;
	String name;
	int age;
	Computer comp;
	
	//方法
	void study() {
		System.out.println("好好学习！"+comp.brand);
	}
	
	//构造方法，用于创建这个类的对象；无参的构造方法可以由系统自动创建（用户未创建时）。
	SxtStu(){
		
	}
	
	//程序执行入口，必须有，也可放到其他类
	public static void main(String[] arges) {
		SxtStu stu1=new SxtStu(); //创建一个对象
		stu1.id=1006;
		stu1.age=23;
		Computer comp1=new Computer();
		comp1.brand="lenovo";
		stu1.comp=comp1;
		stu1.study();
		
	}
	
}

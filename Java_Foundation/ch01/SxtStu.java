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
	
	//成勋执行入口，必须有，也可放到其他类
	public static void main(String[] arges) {
		SxtStu stu=new SxtStu();
		Computer comp1=new Computer();
		comp1.brand="lenovo";
		stu.comp=comp1;
		stu.study();
		
	}
	
	


}

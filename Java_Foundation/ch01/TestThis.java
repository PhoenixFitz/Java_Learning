
public class TestThis {
	int a,b,c;
	
	TestThis(){
		System.out.println("初始化一个无参对象");
	}
	
	TestThis(int a,int b){
		// TestThis(); 这样是无法调用构造方法
	//	this(); //调用无参的构造方法，并且必须位于第一行
		//区分成员变量和局部变量
		this.a=a;
		this.b=b;
		System.out.println("二参构造。");
	}
	
	TestThis(int a,int b,int c){
		this(a,b); //调用无参的构造方法，必须位于第一行
		this.c=c;
		System.out.println("三参构造。");
	}

	void sing() {
		System.out.println("Sing a song!");
	}
	
	void eat() {
		this.sing();
		System.out.println("吃饭了！");
	}
	
	public static void main(String[] args) {
		TestThis hi=new TestThis(2,3,4);
		hi.eat();
	}
}

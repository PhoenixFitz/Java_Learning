public class TestAnonymousInnerClass{
	
	public static void test01(AA a){
		System.out.println("###########");
		a.aa();
	}
	


public static void main(String[] args){
	test.test01(new AA(){         //定义匿名内部类类体
		
		@Override
		public void aa(){
			System.out.println("测试匿名类!");
		}
	});
 }
}

interface AA{
	void aa();
}
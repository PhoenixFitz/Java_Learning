public class TestAnonymousInnerClass{
	
	public static void test01(AA a){
		System.out.println("###########");
		a.aa();
	}
	


public static void main(String[] args){
	test.test01(new AA(){         //���������ڲ�������
		
		@Override
		public void aa(){
			System.out.println("����������!");
		}
	});
 }
}

interface AA{
	void aa();
}


public class TestSuper02 {
	public static void main(String[] args) {
		System.out.println("��ʼ����һ��ChildClass���󡣡�����");
		new ChildClass2();   //new����ʱ������ø�����޲������췽����
	}
}

class FatherClass2{
	public FatherClass2() {
		
	super();
	System.out.println("����FatherClass");
	}
}

class ChildClass2 extends FatherClass2{
	public ChildClass2() {
		super();    //super()������ʾ���ã�javaĬ�ϻ����super()�������ǵ��ø�����޲������췽����
		System.out.println("����ChildaClass");
	}
}



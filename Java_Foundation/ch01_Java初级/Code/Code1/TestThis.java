
public class TestThis {
	int a,b,c;
	
	TestThis(){
		System.out.println("��ʼ��һ���޲ζ���");
	}
	
	TestThis(int a,int b){
		// TestThis(); �������޷����ù��췽��
	//	this(); //�����޲εĹ��췽�������ұ���λ�ڵ�һ��
		//���ֳ�Ա�����;ֲ�����
		this.a=a;
		this.b=b;
		System.out.println("���ι��졣");
	}
	
	TestThis(int a,int b,int c){
		this(a,b); //�����޲εĹ��췽��������λ�ڵ�һ��
		this.c=c;
		System.out.println("���ι��졣");
	}

	void sing() {
		System.out.println("Sing a song!");
	}
	
	void eat() {
		this.sing();
		System.out.println("�Է��ˣ�");
	}
	
	public static void main(String[] args) {
		TestThis hi=new TestThis(2,3,4);
		hi.eat();
	}
}

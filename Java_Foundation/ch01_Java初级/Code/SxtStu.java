class Computer{
	String brand;
}

public class SxtStu {


	
	// ����fields
	int id;
	String name;
	int age;
	Computer comp;
	
	//����
	void study() {
		System.out.println("�ú�ѧϰ��"+comp.brand);
	}
	
	//���췽�������ڴ��������Ķ����޲εĹ��췽��������ϵͳ�Զ��������û�δ����ʱ����
	SxtStu(){
		
	}
	
	//����ִ����ڣ������У�Ҳ�ɷŵ�������
	public static void main(String[] arges) {
		SxtStu stu1=new SxtStu(); //����һ������
		stu1.id=1006;
		stu1.age=23;
		Computer comp1=new Computer();
		comp1.brand="lenovo";
		stu1.comp=comp1;
		stu1.study();
		
	}
	
}

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
	
	//��ѫִ����ڣ������У�Ҳ�ɷŵ�������
	public static void main(String[] arges) {
		SxtStu stu=new SxtStu();
		Computer comp1=new Computer();
		comp1.brand="lenovo";
		stu.comp=comp1;
		stu.study();
		
	}
	
	


}

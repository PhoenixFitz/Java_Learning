/**
 *  
 * ����static�ؼ��ֵ��÷�
 * @author wakl2
 *
 */
public class User2 {
	int id;
	String name;
	String pwd;
	
	static String company = "Lenovo";
	
	public User2(int id,String name) {
		this.id=id;
		this.name=name;
	}
	
	public void login() {
		printCompany();
		System.out.println(company);
		System.out.println("��½�� "+name);
	}
	
	public static void printCompany() {
	//	login(); //���÷Ǿ�̬��Ա������ᱨ��
		System.out.println(company);
	}
	
	// ��̬��
	/*static {
		System.out.println("ִ����ĳ�ʼ������");
		company="Apple";
		printCompany();
	}  */
	
	public static void main(String[] args) {
		User2 u=new User2(101,"liang");
		User2.printCompany();
		User2.company="DELL";
		User2.printCompany();  // �á�����.������/������������
		u.login();
	}
}


/**
 * 
 * @author wakl2
 * ���췽��������
 */
public class User {
	int id;  //id
	String name; //�˻���
	String pwd; //����
	

	// ���췽��
	public User() {
		
	}
	
	public User(int id,String name) {
		super();  //���췽���ĵ�һ������super(),Ҳ��ʡ��
		this.id=id;
		this.name=name;
	}

	public User(int id,String name,String pwd) {
		this.id=id;
		this.name=name;
		this.pwd=pwd;
	}
	
	// ����
	void print(){  
		System.out.println(id+" "+name+" "+pwd);
	}
	
 public static void main(String[] args) {
		User u1=new User();
		User u2=new User(106,"liang");
		User u3=new User(107,"wen","1234");
		u1.print();
		u2.print();
		u3.print();
		
	}
}

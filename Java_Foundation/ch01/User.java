
/**
 * 
 * @author wakl2
 * 构造方法的重载
 */
public class User {
	int id;  //id
	String name; //账户名
	String pwd; //密码
	

	// 构造方法
	public User() {
		
	}
	
	public User(int id,String name) {
		super();  //构造方法的第一句总是super(),也可省略
		this.id=id;
		this.name=name;
	}

	public User(int id,String name,String pwd) {
		this.id=id;
		this.name=name;
		this.pwd=pwd;
	}
	
	// 方法
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

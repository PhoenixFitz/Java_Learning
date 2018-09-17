/**
 *  
 * 测试static关键字的用法
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
		System.out.println("登陆： "+name);
	}
	
	public static void printCompany() {
	//	login(); //调用非静态成员，编译会报错
		System.out.println(company);
	}
	
	public static void main(String[] args) {
		User2 u=new User2(101,"liang");
		User2.printCompany();
		User2.company="DELL";
		User2.printCompany();
		u.login();
	}
}

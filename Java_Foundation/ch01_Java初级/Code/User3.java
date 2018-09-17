
public class User3 {
	int id;
	String name;
	String pwd;
	
	public User3(int id,String name){
		this.id=id;
		this.name=name;
		
	}
	
	public void testParameterTransfer01(User3 u) {
		u.name = "麦克雷";
	}
	
	public void testParameterTransfer02(User3 u) {
		u=new User3(200,"温斯顿");
	}
	
	public static void main(String[] args) {
		User3 u1=new User3(100,"安其拉");
		
		u1.testParameterTransfer01(u1); //该方法参数U传递的是u1的地址，直接改变了该地址中name属性的值
		System.out.println(u1.name);
		
		u1.testParameterTransfer02(u1); //该方法参数U传递的虽然是u1的地址，但是方法体中new语句新生成了一个对象，并将该对象的地址赋给了U，原u1的值没有发生改变
		System.out.println(u1.name);
	}
}

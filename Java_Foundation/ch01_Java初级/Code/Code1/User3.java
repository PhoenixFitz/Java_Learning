
public class User3 {
	int id;
	String name;
	String pwd;
	
	public User3(int id,String name){
		this.id=id;
		this.name=name;
		
	}
	
	public void testParameterTransfer01(User3 u) {
		u.name = "�����";
	}
	
	public void testParameterTransfer02(User3 u) {
		u=new User3(200,"��˹��");
	}
	
	public static void main(String[] args) {
		User3 u1=new User3(100,"������");
		
		u1.testParameterTransfer01(u1); //�÷�������U���ݵ���u1�ĵ�ַ��ֱ�Ӹı��˸õ�ַ��name���Ե�ֵ
		System.out.println(u1.name);
		
		u1.testParameterTransfer02(u1); //�÷�������U���ݵ���Ȼ��u1�ĵ�ַ�����Ƿ�������new�����������һ�����󣬲����ö���ĵ�ַ������U��ԭu1��ֵû�з����ı�
		System.out.println(u1.name);
	}
}

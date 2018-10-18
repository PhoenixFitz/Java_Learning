

/**
 * 测试StringBuilder、StringBuffer 可变的字符序列，及常用方法
 * @author 
 *
 */
public class TestStringBuilder {
	public static void main(String[] args){
		String str;
		//StringBuilder线程不安全，效率高（一般使用他）；StringBuffer线程安全，效率低
		StringBuilder sb=new StringBuilder("Niklaus"); //该类没有final修饰，赋值以后可以修改
		
		System.out.println(Integer.toHexString(sb.hashCode()));
		System.out.println(sb);
		
		sb.setCharAt(2, 'Y');
		System.out.println(Integer.toHexString(sb.hashCode()));//同一个对象，地址不变
		System.out.println(sb);
		
		System.out.println("测试StringBuilder用法");
		StringBuilder sb1=new StringBuilder();
		
		for(int i=0;i<26;i++){
			char temp=(char)('a'+i);
			sb1.append(temp);   //在尾后添加
		}
		System.out.println(sb1);
		
		sb1.reverse();  //倒序
		System.out.println(sb1);
		sb1.setCharAt(3,'棒');
		System.out.println(sb1);
		//链式调用，核心就是：该方法调用了return this，把自己返回了
		sb1.insert(0, '吉').insert(7, '安').insert(9, '娜'); 
		System.out.println(sb1);
		
		sb1.delete(20, 23);  //删除[ , ) 的字符
		System.out.println(sb1);
	}

}


/**
 * 测试包装类
 * Interger类的使用，其他包装类用法类似
 * @author 
 *
 */
public class TestWraooedClass {
	void testInteger(){
		//基本数据类型转成包装类对象
		Integer a= new Integer(3);
		Integer b=Integer.valueOf(30);//官方推荐此方法
		//把包装类对象转成基本数据类型
		int c = b.intValue();
		double d=b.doubleValue();
		//把字符串转换成包装类对象
		Integer e = new Integer("999888");
		Integer f =Integer.parseInt("1888554");
		//把包装类转换成字符串
		String str = f.toString(); // 也可以用 ""+f;
		
		//常见的常量
		System.out.println("int类型最大的常量"+Integer.MAX_VALUE);
	}
	public static void main(String[] args){
		TestWraooedClass test = new TestWraooedClass();
		test.testInteger();
		
		
	}
}

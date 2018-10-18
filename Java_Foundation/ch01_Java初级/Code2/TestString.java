
public class TestString {
	public static void main(String[] args){
		String s1="Niklaus,Snow";  //源码中String是由final修饰，是常量，初始化以后不能再修改
		String s2=s1.substring(2, 7);
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println(Integer.toHexString(s1.hashCode()));
        // 打印：c61, 显然s1和s2不是同一个对象
        System.out.println(Integer.toHexString(s2.hashCode()));
        
      //编译器做了优化,直接在编译的时候将字符串进行拼接
        String str1 = "hello" + " java";//相当于str1 = "hello java";
        String str2 = "hello java";
        System.out.println(str1 == str2);//true  属于同一个对象
        String str3 = "hello";
        String str4 = " java";
        //编译的时候不知道变量中存储的是什么,所以没办法在编译的时候优化
        String str5 = str3 + str4;
        System.out.println(str2 == str5);//false
	}
}

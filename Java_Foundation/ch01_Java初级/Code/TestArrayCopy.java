package array;
/**
 * 数组的拷贝
 * @author kl
 *
 */

public class TestArrayCopy {
	public static void main(String[] args){
		System.out.println("-----testcopy-----");
		testBasicCopy();
		//testBasicCopy2();
		System.out.println("-----testdelele-----");
		String[] str={"阿里","尚学堂","京东","搜狐","网易"}; 
		testElementDelete(str,2);
		System.out.println("-----testinsert-----");
		
		testElementInsert(str,2,"亚马逊");
		
	}
	//测试拷贝
	public static void testBasicCopy(){
		String[] s1={"aa","bb","cc","dd","ee"};
		String[] s2=new String[10];
		System.arraycopy(s1,2,s2,6,3);
		for(int i=0;i<s2.length;i++)
			System.out.println(i+"--"+s2[i]);
	}
	//测试从数组中删除某个元素（本质上是数组的拷贝）
	
	public static void testBasicCopy2(){
		String[] s1={"aa","bb","cc","dd","ee"};
		System.arraycopy(s1,3,s1,2,s1.length-3);
		s1[s1.length-1]=null;
		for(int i=0;i<s1.length;i++)
			System.out.println(i+"--"+s1[i]);
	}
	
	public static String[] testElementDelete(String[] s,int index){
		System.arraycopy(s, index+1,s, index, s.length-index-1);
		s[s.length-1]=null;
		for(int i=0;i<s.length;i++)
			System.out.println(i+"--"+s[i]);
		return s;
		
	}
	
	//测试在指定位置插入元素（本质上也是拷贝）
	public static String[] testElementInsert(String[] s,int index,String str){
		//插入之前需要进行数组的扩容，本质上是先定义一个更大的数组，然后将原数组内容原封不动拷贝到新数组中
		String[] str2=new String[s.length+5];
		System.arraycopy(s, 0, str2, 0, s.length);
		//index后的元素向后移动一个位置
		System.arraycopy(s, index, str2, index+1, s.length-index);
		str2[index]=str;
		for(int i=0;i<str2.length;i++)
			System.out.println(i+"--"+str2[i]);
		return str2;
	}
}

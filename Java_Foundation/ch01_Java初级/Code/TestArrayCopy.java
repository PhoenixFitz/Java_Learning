package array;
/**
 * ����Ŀ���
 * @author kl
 *
 */

public class TestArrayCopy {
	public static void main(String[] args){
		System.out.println("-----testcopy-----");
		testBasicCopy();
		//testBasicCopy2();
		System.out.println("-----testdelele-----");
		String[] str={"����","��ѧ��","����","�Ѻ�","����"}; 
		testElementDelete(str,2);
		System.out.println("-----testinsert-----");
		
		testElementInsert(str,2,"����ѷ");
		
	}
	//���Կ���
	public static void testBasicCopy(){
		String[] s1={"aa","bb","cc","dd","ee"};
		String[] s2=new String[10];
		System.arraycopy(s1,2,s2,6,3);
		for(int i=0;i<s2.length;i++)
			System.out.println(i+"--"+s2[i]);
	}
	//���Դ�������ɾ��ĳ��Ԫ�أ�������������Ŀ�����
	
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
	
	//������ָ��λ�ò���Ԫ�أ�������Ҳ�ǿ�����
	public static String[] testElementInsert(String[] s,int index,String str){
		//����֮ǰ��Ҫ������������ݣ����������ȶ���һ����������飬Ȼ��ԭ��������ԭ�ⲻ����������������
		String[] str2=new String[s.length+5];
		System.arraycopy(s, 0, str2, 0, s.length);
		//index���Ԫ������ƶ�һ��λ��
		System.arraycopy(s, index, str2, index+1, s.length-index);
		str2[index]=str;
		for(int i=0;i<str2.length;i++)
			System.out.println(i+"--"+str2[i]);
		return str2;
	}
}

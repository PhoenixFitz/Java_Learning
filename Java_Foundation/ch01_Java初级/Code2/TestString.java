
public class TestString {
	public static void main(String[] args){
		String s1="Niklaus,Snow";  //Դ����String����final���Σ��ǳ�������ʼ���Ժ������޸�
		String s2=s1.substring(2, 7);
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println(Integer.toHexString(s1.hashCode()));
        // ��ӡ��c61, ��Ȼs1��s2����ͬһ������
        System.out.println(Integer.toHexString(s2.hashCode()));
        
      //�����������Ż�,ֱ���ڱ����ʱ���ַ�������ƴ��
        String str1 = "hello" + " java";//�൱��str1 = "hello java";
        String str2 = "hello java";
        System.out.println(str1 == str2);//true  ����ͬһ������
        String str3 = "hello";
        String str4 = " java";
        //�����ʱ��֪�������д洢����ʲô,����û�취�ڱ����ʱ���Ż�
        String str5 = str3 + str4;
        System.out.println(str2 == str5);//false
	}
}



/**
 * ����StringBuilder��StringBuffer �ɱ���ַ����У������÷���
 * @author 
 *
 */
public class TestStringBuilder {
	public static void main(String[] args){
		String str;
		//StringBuilder�̲߳���ȫ��Ч�ʸߣ�һ��ʹ��������StringBuffer�̰߳�ȫ��Ч�ʵ�
		StringBuilder sb=new StringBuilder("Niklaus"); //����û��final���Σ���ֵ�Ժ�����޸�
		
		System.out.println(Integer.toHexString(sb.hashCode()));
		System.out.println(sb);
		
		sb.setCharAt(2, 'Y');
		System.out.println(Integer.toHexString(sb.hashCode()));//ͬһ�����󣬵�ַ����
		System.out.println(sb);
		
		System.out.println("����StringBuilder�÷�");
		StringBuilder sb1=new StringBuilder();
		
		for(int i=0;i<26;i++){
			char temp=(char)('a'+i);
			sb1.append(temp);   //��β�����
		}
		System.out.println(sb1);
		
		sb1.reverse();  //����
		System.out.println(sb1);
		sb1.setCharAt(3,'��');
		System.out.println(sb1);
		//��ʽ���ã����ľ��ǣ��÷���������return this�����Լ�������
		sb1.insert(0, '��').insert(7, '��').insert(9, '��'); 
		System.out.println(sb1);
		
		sb1.delete(20, 23);  //ɾ��[ , ) ���ַ�
		System.out.println(sb1);
	}

}

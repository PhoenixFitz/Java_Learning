
/**
 * ���԰�װ��
 * Interger���ʹ�ã�������װ���÷�����
 * @author hanbaozhen1
 *
 */
public class TestWraooedClass {
	void testInteger(){
		//������������ת�ɰ�װ�����
		Integer a= new Integer(3);
		Integer b=Integer.valueOf(30);//�ٷ��Ƽ��˷���
		//�Ѱ�װ�����ת�ɻ�����������
		int c = b.intValue();
		double d=b.doubleValue();
		//���ַ���ת���ɰ�װ�����
		Integer e = new Integer("999888");
		Integer f =Integer.parseInt("1888554");
		//�Ѱ�װ��ת�����ַ���
		String str = f.toString(); // Ҳ������ ""+f;
		
		//�����ĳ���
		System.out.println("int�������ĳ���"+Integer.MAX_VALUE);
	}
	public static void main(String[] args){
		TestWraooedClass test = new TestWraooedClass();
		test.testInteger();
		
		
	}
}

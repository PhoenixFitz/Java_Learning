
/**
 * �����Զ�װ�䣬�Զ�����
 * @author hanbaozhen1
 *
 */

public class TestAutoBox {
	public static void main(String[] args){
		Integer a=234; //�Զ�װ�䡣 Integer a =Integer.valueOf(234);
		int b=a;// �Զ����䡣���������޸ĳɣ� int b= a.intValue();
		
		Integer c= null;
		if(c!=null){
			int d = c; //�Զ����䣬������c.intValue();
		}
		
		//����[-128,127]֮������֡�ʵ����ϵͳ��ʼ��ʱ�򣬴�����[-128��127]֮���һ����������
		//�����ǵ���valueOf()��ʱ�����ȼ���Ƿ���[-128,127]֮�䣬����������Χ��ֱ�Ӵӻ����������ó��Ѿ����õĶ���
		//������������Χ���򴴽��µ�Integer����
		Integer in1=Integer.valueOf(-128);
		Integer in2=-128;
		System.out.println(in1 == in2);// true ��Ϊ-128�ڻ��淶Χ��
		System.out.println(in1.equals(in2));//true
		System.out.println("############");
		Integer in3=1234;
		Integer in4=1234;
		System.out.println(in3==in4); // false ��Ϊ1234���ڻ��淶Χ��
		System.out.println(in3.equals(in4)); //true
	}
}

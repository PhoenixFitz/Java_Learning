package array;
import java.util.Arrays;
/**
 * ����java.util.Arrays��
 * @author kl
 *
 */
public class TestArrays {
	public static void main(String[] args){
		
		int[] a={100,20,30,76,94,2,13,65};
		System.out.println(a);  //�������ĵ�ַ
		System.out.println(Arrays.toString(a)); //���������Ԫ��
		Arrays.sort(a);  //�������ڵ�Ԫ�ؽ�������
		System.out.println(Arrays.toString(a));
		//���ö��ֲ��ҷ�����ѯָ��Ԫ�ص�����λ�ò����ظ��������,���ﷵ��3����δ�鵽��Ԫ���򷵻�-1
		System.out.println(Arrays.binarySearch(a,30)); 
		Arrays.fill(a, 5,7, 999);  //��[5,7)�����ϵ�Ԫ���滻Ϊ999;
        System.out.println(Arrays.toString(a));
	}

}

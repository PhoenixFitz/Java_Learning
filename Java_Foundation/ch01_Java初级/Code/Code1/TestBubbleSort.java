package array;
/**
 * ð����������㷨
 */

import java.util.Arrays;

public class TestBubbleSort {
	public static void main(String[] args){
		int[] values = { 3, 1, 6, 2, 9, 0, 7, 4, 5, 8 };
		int temp;
		// ���ѭ����n��Ԫ��������������Ҫn-1��ѭ��
		for(int i=0;i<values.length-1;i++){
			boolean flag=true;  //��һ����ǣ���������λ�ý���������Ϊfalse
			//�ڲ�ѭ����ÿһ��ѭ���������е�ǰ����Ԫ�ؿ�ʼ���бȽϣ��Ƚϵ�������������
			for(int j=0;j<values.length-1-i;j++){
				if(values[j]>values[j+1]){
					temp=values[j];
					values[j]=values[j+1];
					values[j+1]=temp;
					//���˷����˽����������������ڱ��˴�������״̬����Ҫ�����Ƚϣ�
					flag=false;
				}
			}
			//���ݱ������ֵ�ж������Ƿ���������������˳������������ѭ����
			if(flag){
				System.out.println("��������ɣ�������");
				break;
				
			}
		System.out.println(Arrays.toString(values));
		}
		//System.out.println(Arrays.toString(values));
	}
}

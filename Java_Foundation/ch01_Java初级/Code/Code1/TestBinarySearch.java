package array;
import java.util.Arrays;

public class TestBinarySearch {
	public static void main(String[] args){
		int[] arr = { 30,20,50,10,80,9,7,12,100,40,8};
        int searchWord = 20; // ��Ҫ���ҵ���
        Arrays.sort(arr); //���ַ�����֮ǰ��һ��Ҫ������Ԫ������
        System.out.println(Arrays.toString(arr));
        System.out.println(searchWord+"Ԫ�ص������� "+MyBinarySearch(arr,searchWord));
        System.out.println("800Ԫ�ص������� "+MyBinarySearch(arr,800));
	}
	
	public static int MyBinarySearch(int[] arr,int value){
		int low=0;
		int high=arr.length-1;
		while(low<=high){
			int mid=(low+high)/2;
			if (value==arr[mid]){
				return mid; //���ز�ѯ��������λ��
			}
			if (value>arr[mid]){
				low=mid+1;	 //mid�ĺ�һ��λ��
			}
			if (value<arr[mid]){
				high=mid-1;   // mid��ǰһ��λ��
			}
		}
		return -1;//����ѭ����ϣ�˵��δ�ҵ�������-1
	}
}

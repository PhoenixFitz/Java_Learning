package array;
import java.util.Arrays;

public class TestBinarySearch {
	public static void main(String[] args){
		int[] arr = { 30,20,50,10,80,9,7,12,100,40,8};
        int searchWord = 20; // 所要查找的数
        Arrays.sort(arr); //二分法查找之前，一定要对数组元素排序
        System.out.println(Arrays.toString(arr));
        System.out.println(searchWord+"元素的索引： "+MyBinarySearch(arr,searchWord));
        System.out.println("800元素的索引： "+MyBinarySearch(arr,800));
	}
	
	public static int MyBinarySearch(int[] arr,int value){
		int low=0;
		int high=arr.length-1;
		while(low<=high){
			int mid=(low+high)/2;
			if (value==arr[mid]){
				return mid; //返回查询到的索引位置
			}
			if (value>arr[mid]){
				low=mid+1;	 //mid的后一个位置
			}
			if (value<arr[mid]){
				high=mid-1;   // mid的前一个位置
			}
		}
		return -1;//上面循环完毕，说明未找到，返回-1
	}
}

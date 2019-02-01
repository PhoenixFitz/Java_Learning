package array;
import java.util.Arrays;
/**
 * 测试java.util.Arrays类
 * @author kl
 *
 */
public class TestArrays {
	public static void main(String[] args){
		
		int[] a={100,20,30,76,94,2,13,65};
		System.out.println(a);  //输出数组的地址
		System.out.println(Arrays.toString(a)); //输出数组内元素
		Arrays.sort(a);  //对数组内的元素进行排序
		System.out.println(Arrays.toString(a));
		//利用二分查找方法查询指定元素的索引位置并返回该索引序号,这里返回3，若未查到该元素则返回-1
		System.out.println(Arrays.binarySearch(a,30)); 
		Arrays.fill(a, 5,7, 999);  //将[5,7)索引上的元素替换为999;
        System.out.println(Arrays.toString(a));
	}

}

package array;
/**
 * 冒泡排序基本算法
 */

import java.util.Arrays;

public class TestBubbleSort {
	public static void main(String[] args){
		int[] values = { 3, 1, 6, 2, 9, 0, 7, 4, 5, 8 };
		int temp;
		// 外层循环：n个元素排序，则至多需要n-1趟循环
		for(int i=0;i<values.length-1;i++){
			boolean flag=true;  //加一个标记，若发生了位置交换，则置为false
			//内层循环：每一趟循环都从数列的前两个元素开始进行比较，比较到无序数组的最后
			for(int j=0;j<values.length-1-i;j++){
				if(values[j]>values[j+1]){
					temp=values[j];
					values[j]=values[j+1];
					values[j+1]=temp;
					//本趟发生了交换，表明该数组在本趟处于无序状态，需要继续比较；
					flag=false;
				}
			}
			//根据标记量的值判断数组是否有序，如果有序，则退出；无序，则继续循环。
			if(flag){
				System.out.println("排序已完成，结束！");
				break;
				
			}
		System.out.println(Arrays.toString(values));
		}
		//System.out.println(Arrays.toString(values));
	}
}

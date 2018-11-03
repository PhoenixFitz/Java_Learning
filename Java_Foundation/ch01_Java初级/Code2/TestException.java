

/**
 * 运行时异常的处理
 * @author 
 *
 */
public class TestException {
	public static void main(String[] args){
		int a=0;
		int b=2;
		if(a!=0){
		System.out.println(b/a);
		}
		// 解决空指针异常
		String str=null;
		if(str!=null){  
			System.out.println(str.length());
		}
		// 解决类型转换异常
		Animal d =new Dog();
		if(d instanceof Cat){
		Cat c=(Cat)d;
		}
		// 解决数组下标越界异常
		int[] arr=new int[5];
		int a2=5;
		if(a2<arr.length){
			System.out.println(arr[a2]);
		}
		
		
		
		
	}
}



class Animal{
	
}

class Dog extends Animal{
	
}

class Cat extends Animal{
	
}


/**
 * ����ʱ�쳣�Ĵ���
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
		// �����ָ���쳣
		String str=null;
		if(str!=null){  
			System.out.println(str.length());
		}
		// �������ת���쳣
		Animal d =new Dog();
		if(d instanceof Cat){
		Cat c=(Cat)d;
		}
		// ��������±�Խ���쳣
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
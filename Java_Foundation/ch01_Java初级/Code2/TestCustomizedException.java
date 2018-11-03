

public class TestCustomizedException {

	
	public static void main(String[] args){
		Person p =new Person();
		p.setAge(-1);
	}
}

class Person{
	private int age;

	public int getAge() {
		return age;
	}

	
	public void setAge(int age) {
		if(age<0){
			throw new IllegalAgeException("���䲻��Ϊ������");
		}
		this.age = age;
	}

class IllegalAgeException extends RuntimeException{  //����ʱ�쳣
	public IllegalAgeException(){
		
	}
	
	public IllegalAgeException(String msg){
		super(msg);
	}
  }
}


/*
class Person{
 
	private int age;

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age<0){
			try {
				throw new IllegalAgeException("���䲻��Ϊ������");
			} catch (IllegalAgeException e) {
				
				e.printStackTrace();
			}
		}
		this.age = age;
	}
	
	
}
	
	
class IllegalAgeException extends Exception{    //�������쳣������Ҫ�����쳣����
	public IllegalAgeException(){
		
	}
	
	public IllegalAgeException(String msg){
		super(msg);
	}
	
}
*/
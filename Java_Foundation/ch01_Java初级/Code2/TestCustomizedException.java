

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
			throw new IllegalAgeException("年龄不能为负数。");
		}
		this.age = age;
	}

class IllegalAgeException extends RuntimeException{  //运行时异常
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
				throw new IllegalAgeException("年龄不能为负数。");
			} catch (IllegalAgeException e) {
				
				e.printStackTrace();
			}
		}
		this.age = age;
	}
	
	
}
	
	
class IllegalAgeException extends Exception{    //编译器异常，是需要进行异常处理
	public IllegalAgeException(){
		
	}
	
	public IllegalAgeException(String msg){
		super(msg);
	}
	
}
*/
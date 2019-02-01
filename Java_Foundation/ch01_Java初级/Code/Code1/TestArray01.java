package kang;

class Man{
    private int age;
    private int id;
    public Man(int id,int age) {
        super();
        this.age = age;
        this.id = id;
    }
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
public class TestArray01 {
    public static void main(String[] args) {
    	int[] s = null; // 声明数组；
        s = new int[10]; // 给数组分配空间；
        for (int i = 0; i < 10; i++) {
            s[i] = 2 * i + 1;//给数组元素赋值；
            System.out.println(s[i]);
        }
        System.out.println("##########");
    	
        Man[] mans;  //声明引用类型数组； 
        mans = new Man[10];  //给引用类型数组分配空间；
         
        Man m1 = new Man(1,11);
        Man m2 = new Man(2,22);  
        Man m3 = new Man(3,33);
         
        mans[0]=m1;//给引用类型数组元素赋值；
        mans[1]=m2;//给引用类型数组元素赋值；
        mans[2]=m3;
        
        for(int i=0;i<3;i++){
        	System.out.println(mans[i].getId()+"     "+mans[i].getAge());
        }
    }
}
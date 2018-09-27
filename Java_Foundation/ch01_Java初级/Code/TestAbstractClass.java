//抽象类
abstract class Animal {
    abstract public void shout();  //抽象方法，没有方法体，只有声明
}
class Dog extends Animal { 
    //子类必须实现父类的抽象方法，否则编译错误
    public void shout() {
        System.out.println("汪汪汪！");
    }
    public void seeDoor(){
        System.out.println("看门中....");
    }
}
//测试抽象类
public class TestAbstractClass {
    public static void main(String[] args) {
        Dog a = new Dog();
	Animal b = new Dog(); //可以创建
      //Animal c = new Animal(); // 编译错误，不能用new来实例化抽象类。
        a.shout();
        a.seeDoor();
    }
}
 class Outer{
    //相当于外部类的一个静态成员
    static class Inner{
    }
}
public class TestStaticInnerClass {
    public static void main(String[] args) {
        //通过 new 外部类名.内部类名() 来创建内部类对象
        Outer.Inner inner =new Outer.Inner();
    }
}
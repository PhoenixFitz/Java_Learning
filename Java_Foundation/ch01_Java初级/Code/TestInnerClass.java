class Outer {
    private int age = 10;
    class Inner {
        int age = 20;
        public void show() {
            int age = 30;
            System.out.println("内部类方法里的局部变量age:" + age);// 30
            System.out.println("内部类的成员变量age:" + this.age);// 20
            System.out.println("外部类的成员变量age:" + Outer.this.age);// 10
        }
    }
}

public class TestInnerClass {
    public static void main(String[] args) {
        //外部类以外的地方使用非静态内部类：先创建外部类实例，然后使用该外部类实例创建内部类实例
        Outer.Inner inner = new Outer().new Inner();
        inner.show();
        Outer outer = new Outer();
        Outer.Inner inn = outer.new Inner();
        inn.show();
    }
}


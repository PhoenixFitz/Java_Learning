public class TestLocalInnerClass {
    public void show() {
        //作用域仅限于该方法
        class Inner {
            public void fun() {
                System.out.println("helloworld");
            }
        }
        new Inner().fun();
    }
    public static void main(String[] args) {
        new Test2().show();
    }
}
public class TestLocalInnerClass {
    public void show() {
        //����������ڸ÷���
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
class Outer {
    private int age = 10;
    class Inner {
        int age = 20;
        public void show() {
            int age = 30;
            System.out.println("�ڲ��෽����ľֲ�����age:" + age);// 30
            System.out.println("�ڲ���ĳ�Ա����age:" + this.age);// 20
            System.out.println("�ⲿ��ĳ�Ա����age:" + Outer.this.age);// 10
        }
    }
}

public class TestInnerClass {
    public static void main(String[] args) {
        //�ⲿ������ĵط�ʹ�÷Ǿ�̬�ڲ��ࣺ�ȴ����ⲿ��ʵ����Ȼ��ʹ�ø��ⲿ��ʵ�������ڲ���ʵ��
        Outer.Inner inner = new Outer().new Inner();
        inner.show();
        Outer outer = new Outer();
        Outer.Inner inn = outer.new Inner();
        inn.show();
    }
}


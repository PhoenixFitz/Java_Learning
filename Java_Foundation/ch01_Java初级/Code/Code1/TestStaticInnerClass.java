 class Outer{
    //�൱���ⲿ���һ����̬��Ա
    static class Inner{
    }
}
public class TestStaticInnerClass {
    public static void main(String[] args) {
        //ͨ�� new �ⲿ����.�ڲ�����() �������ڲ������
        Outer.Inner inner =new Outer.Inner();
    }
}
public class TestMethod {
    /** main�������������� */
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        //������͵ķ�������num1��num2��ֵ����add�����е�n1��n2
        // ����ͺ󽫽�����أ���sum���ս��
        int sum = add(num1, num2);
        System.out.println("sum = " + sum);//�����sum = 30
        //���ô�ӡ�ķ������÷���û�з���ֵ
	TestMethod test=new TestMethod();
        test.print();
    }
    /** ��͵ķ��� */
    public static int add(int n1, int n2) {
        int sum = n1 + n2;
        return sum;//return�������ã�1.�������������С�2.����ֵ
    }
    /** ��ӡ�ķ��� */
    void print() {
        System.out.println("������ѧ��...");
    }
}
public class TestStringEquals {
    public static void main(String[] args) {
        String g1 = "������ѧ��";
        String g2 = "������ѧ��";
        String g3 = new String("������ѧ��");
        System.out.println(g1 == g2); // true  ָ��ͬ�����ַ�����������
        System.out.println(g1 == g3); // false  g3���´����Ķ���
        System.out.println(g1.equals(g3)); // true  g1��g3������ַ���������һ����
    }
}
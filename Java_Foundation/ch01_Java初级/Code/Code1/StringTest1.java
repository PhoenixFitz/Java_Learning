public class StringTest1 {
    public static void main(String[] args) {
        String s1 = "core Java";
        String s2 = "Core Java";
        System.out.println(s1.charAt(3));//��ȡ�±�Ϊ3���ַ������Ϊe
        System.out.println(s2.length());//�ַ����ĳ��ȣ����Ϊ9
        System.out.println(s1.equals(s2));//�Ƚ������ַ����Ƿ���ȣ����Ϊfalse
        System.out.println(s1.equalsIgnoreCase(s2));//�Ƚ������ַ��������Դ�Сд�����Ϊtrue
        System.out.println(s1.indexOf("Java"));//�ַ���s1���Ƿ����Java,��ͷ��ʼ�������ַ���"Java"���ַ����е�����λ�ã���δ�ҵ�����-1.���Ϊ5��
        System.out.println(s1.indexOf("apple"));//�ַ���s1���Ƿ����apple����ͷ��ʼ�������ַ���"apple"���ַ����е�����λ�ã���δ�ҵ�����-1.���Ϊ-1.
        String s = s1.replace(' ', '&');//��s1�еĿո��滻��&
        System.out.println("result is :" + s); //���Ϊ result is ��core&Java
    }
}
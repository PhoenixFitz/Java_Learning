public class StringTest2 {
    public static void main(String[] args) {
        String s = "";
        String s1 = "How are you?";
        System.out.println(s1.startsWith("How"));//�Ƿ���How��ͷ�����Ϊtrue
        System.out.println(s1.endsWith("you"));//�Ƿ���you��β�����Ϊfalse
        s = s1.substring(4);//��ȡ���ַ��������±�Ϊ4�Ŀ�ʼ���ַ�����βΪֹ�����Ϊare you?
        System.out.println(s);
        s = s1.substring(4, 7);//��ȡ���ַ������±�[4, 7) ������7�����Ϊare
        System.out.println(s);
        s = s1.toLowerCase();//תСд�����Ϊhow are you��
        System.out.println(s);
        s = s1.toUpperCase();//ת��д�����ΪHOW ARE YOU?
        System.out.println(s);
        String s2 = "  How old are you!! ";
        s = s2.trim();//ȥ���ַ�����β�Ŀո�ע�⣺�м�Ŀո���ȥ�������ΪHow old are you!!
        System.out.println(s);
        System.out.println(s2);//��ΪString�ǲ��ɱ��ַ���������s2����,���Ϊ  How old are you!!
    }
}
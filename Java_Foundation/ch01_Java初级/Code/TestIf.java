public class TestIf {
    public static void main(String[] args) {
        //ͨ�����������ӿ��������������Σ�
        int i = (int)(6 * Math.random()) + 1;//ͨ��Math.random()���������[0,6]
        int j = (int)(6 * Math.random()) + 1;
        int k = (int)(6 * Math.random()) + 1;
        int count = i + j + k;
        //�����������֮�ʹ���15������������
        if(count > 15) {
            System.out.println("������������");
        }
        //�����������֮����10��15֮�䣬������һ��
        if(count >= 10 && count <= 15) { //����д����10<=count<=15
            System.out.println("����������һ��");
        }
        //�����������֮��С��10������������ô��
        if(count < 10) {
            System.out.println("������������ô��");
        }
        System.out.println("����" + count + "��");
    }
public class TestRecursion {
    public static void main(String[] args) {
        long d1 = System.currentTimeMillis();  
        System.out.printf("%d�׳˵Ľ��:%s%n", 10, factorial(10));
//%s �ַ����� %n���з���Ҳ����\n��
        long d2 = System.currentTimeMillis();
        System.out.printf("�ݹ��ʱ��%s%n", d2-d1);  //��ʱ��32ms
    }
    /** ��׳˵ķ���*/
    static long  factorial(int n){
        if(n==1){//�ݹ�ͷ
            return 1;
        }else{//�ݹ���
            return n*factorial(n-1);//n! = n * (n-1)!
        }
    }
}
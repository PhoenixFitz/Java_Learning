public class TestForeach {
    public static void main(String[] args) {
        int[] a = new int[4];
        //��ʼ������Ԫ�ص�ֵ
        for(int i=0;i<a.length;i++){
            a[i] = 100*i;
        }
        //��ȡԪ�ص�ֵ
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
	System.out.println("#########");
	for(int m:a){     //foreachѭ����ֻ���ڶ�ȡ����Ԫ�ص�ֵ�������޸�Ԫ�ص�ֵ��
		System.out.println(m);
	}
	System.out.println("#########");
	String[] ss = { "aa", "bbb", "ccc", "ddd" };
        for (String temp : ss) {
            System.out.println(temp);
        }
    }
}
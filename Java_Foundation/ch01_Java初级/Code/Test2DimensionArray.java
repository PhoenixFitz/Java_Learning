


//Ϊ�˷���ѧϰ��Ƚϣ��Ѽ�����������һ����
import java.util.Arrays;

// ��ά���������
public class Test1 {
    public static void main(String[] args) {
        // Java�ж�ά����������ͳ�ʼ��Ӧ���ӵ�ά����ά��˳�����
        int[][] a = new int[3][];
        a[0] = new int[2];
        a[1] = new int[4];
        a[2] = new int[3];
        // int a1[][]=new int[][4];//�Ƿ�
    }
}



//��ά����ľ�̬��ʼ��
public class Test2 {
    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3 }, { 3, 4 }, { 3, 5, 6, 7 } };
        System.out.println(a[2][3]);  //���7
    }
}


//��ά����Ķ�̬��ʼ��

public class Test3 {
    public static void main(String[] args) {
        int[][] a = new int[3][];
        // a[0] = {1,2,5}; //����û���������;ͳ�ʼ��
        a[0] = new int[] { 1, 2 };
        a[1] = new int[] { 2, 2 };
        a[2] = new int[] { 2, 2, 3, 4 };
        System.out.println(a[2][3]);
        System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.toString(a[1]));
        System.out.println(Arrays.toString(a[2]));
	//��ȡ�Ķ�ά�����һά����ĳ��ȡ�����3
	System.out.println(a.length);
	//��ȡ�ڶ�ά��һ�����鳤�ȡ�����2
	System.out.println(a[0].length); 
    }
}
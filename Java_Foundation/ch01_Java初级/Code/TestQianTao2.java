public class TestQianTao2{
	public static void main(String[] args){
	for (int i = 1; i < 10; i++) { // i��һ������
            for (int j = 1; j <= i; j++) { // j����һ������
                System.out.print(j + "*" + i + "=" + (i * j < 10 ? (" " + i * j) : i * j) + "  ");
            }
            System.out.println();
        }
    }
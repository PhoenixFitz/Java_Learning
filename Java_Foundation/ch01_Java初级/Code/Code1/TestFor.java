public class TestFor {
    public static void main(String args[]) {
        int sum = 0;
        //1.��1-100֮����ۼӺ�
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println("Sum= " + sum);
        //2.ѭ�����9-1֮�����
        for(int i=9;i>0;i--){
            System.out.print(i+"��");
        }
        System.out.println();
        //3.���90-1֮���ܱ�3��������
        for(int i=90;i>0;i-=3){
            System.out.print(i+"��");
        }
        System.out.println();
    }
}
public class TestFor {
    public static void main(String args[]) {
        int sum = 0;
        //1.求1-100之间的累加和
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        System.out.println("Sum= " + sum);
        //2.循环输出9-1之间的数
        for(int i=9;i>0;i--){
            System.out.print(i+"、");
        }
        System.out.println();
        //3.输出90-1之间能被3整除的数
        for(int i=90;i>0;i-=3){
            System.out.print(i+"、");
        }
        System.out.println();
    }
}
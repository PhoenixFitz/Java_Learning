public class TestWhile {
    public static void main(String[] args) {
        int  i = 0;
        int  sum = 0;
        // 1+2+3+¡­+100=?
        while (i <= 100) {
            sum += i;//Ïàµ±ÓÚsum = sum+i;
            i++;
        }
        System.out.println("Sum= " + sum);
    }
}
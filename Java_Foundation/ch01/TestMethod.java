public class TestMethod {
    /** main方法：程序的入口 */
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        //调用求和的方法：将num1与num2的值传给add方法中的n1与n2
        // 求完和后将结果返回，用sum接收结果
        int sum = add(num1, num2);
        System.out.println("sum = " + sum);//输出：sum = 30
        //调用打印的方法：该方法没有返回值
	TestMethod test=new TestMethod();
        test.print();
    }
    /** 求和的方法 */
    public static int add(int n1, int n2) {
        int sum = n1 + n2;
        return sum;//return两个作用：1.结束方法的运行。2.返回值
    }
    /** 打印的方法 */
    void print() {
        System.out.println("北京尚学堂...");
    }
}
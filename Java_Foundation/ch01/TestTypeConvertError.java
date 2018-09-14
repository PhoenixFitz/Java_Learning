public class TestTypeConvertError{
	public static void main(String[] args){
	int money = 1000000000; //10亿
	int years = 20;
	//返回的total是负数，超过了int的范围
	int total = money*years;
	System.out.println("total="+total);
	//返回的total仍然是负数。默认是int，因此结果会转成int值，再转成	long。但是已经发生//了数据丢失
	long total1 = money*years; 
	System.out.println("total1="+total1);
	//返回的total2正确:先将一个因子变成long，整个表达式发生提升。全	部用long来计算。
	long total2 = money*((long)years); 
	System.out.println("total2="+total2);
	}
}
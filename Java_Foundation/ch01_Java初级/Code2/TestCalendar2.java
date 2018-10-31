

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 可视化日历程序
 * @author
 *
 */
public class TestCalendar2 {
	
	public static void main(String[] args) throws ParseException{
		System.out.println("请输入日期（格式：2020-10-6）：");
		Scanner scanner=new Scanner(System.in);
		String str=scanner.nextLine();
		
		// 将输入的字符串转化成日期类
		DateFormat	df=new SimpleDateFormat("yyyy-MM-dd");
		Date date=df.parse(str);
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		int day=c.get(Calendar.DAY_OF_MONTH);
		int days=c.getActualMaximum(Calendar.DATE);   //存储该月的最大天数
		
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		c.set(Calendar.DAY_OF_MONTH,1);    //设置从1号开始
		//确定1号是周几，并在之前的星期前打上空格；周日是1，周一是2……
		for(int i=0;i<c.get(Calendar.DAY_OF_WEEK)-1;i++){
			System.out.print("\t");
		}
		
		for(int i=1;i<=days;i++){
			if(day==c.get(Calendar.DAY_OF_MONTH)){
				System.out.print(c.get(Calendar.DAY_OF_MONTH)+"*\t");
			}else{			
			System.out.print(c.get(Calendar.DAY_OF_MONTH)+"\t");
			}
			if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
				System.out.println(); 				//若该日期是周六，换行
			}
			c.add(Calendar.DAY_OF_MONTH,1);
		}
	}
}

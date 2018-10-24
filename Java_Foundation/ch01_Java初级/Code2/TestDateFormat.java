

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试时间对象和字符串之间的互相转换
 * DateFormat抽象类和SimpleDateFormat实现类的使用
 * @author 
 *
 */
public class TestDateFormat {
	public static void main(String[] args) throws ParseException{
		
		//把时间对象按照“格式字符串指定的格式”转成相应的字符串
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM-dd");
		String str = df.format(new Date(40000000));
		System.out.println(str);
		System.out.println(s2.format(new Date()));
       	 	System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date()));
		System.out.println("################");
		//把字符串按照“格式字符串指定的格式”转换成相应的时间对象
		
		DateFormat df2= new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
		Date date=df2.parse("1983年05月10日 10时46分55秒");
		System.out.println(date);
		date=df.parse("2018-10-06 20:15:30");
		System.out.println("date1: "+date);
		String time = "2018-10-06";
        	date = s2.parse(time);
        	System.out.println("date2: " + date);
        	System.out.println("################");
		
		//测试其他的格式字符,比如：利用D，获得该时间对象是所处年份的第几天
		DateFormat df3=new SimpleDateFormat("D");
		String str3=df3.format(new Date());
		System.out.println(str3);
		
				
	}
}

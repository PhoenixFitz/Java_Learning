
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {
	public static void main(String[] args){
		
		//获得日期的相关元素
		Calendar calendar= new GregorianCalendar(2050,10,6,22,6,35);
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH);
		int day=calendar.get(Calendar.DATE); //也可以使用：DAY_OF_MONTH
		int weekday=calendar.get(Calendar.DAY_OF_WEEK);//星期几，1-7 1：星期日；2：星期一…… 7：星期六
		System.out.println(year);
		System.out.println(month);//0-11 表示对应月份.0是1月份，……11是12月份
		System.out.println(weekday);
		System.out.println(day);
		
		//设置日期的相关元素
		Calendar c2= new GregorianCalendar();  //创建当前时间的日历
		c2.set(Calendar.YEAR,8102);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DATE, 6);
		c2.set(Calendar.HOUR_OF_DAY,22);
		c2.set(Calendar.MINUTE, 55);
		c2.set(Calendar.SECOND, 40);
		printCalendar(c2);
		//日期的计算
		Calendar c3= new GregorianCalendar();  
		c3.add(Calendar.MONTH, 2);
		c3.add(Calendar.DATE, -10);
		System.out.println(c3);
		
		//日历对象和时间对象的转化
		Date d4= c3.getTime();
		Calendar c4= new GregorianCalendar();
		c4.setTime(new Date());
		printCalendar(c4);
		
	}
	
	public static void printCalendar(Calendar c){   //打印日期的方法
		
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH)+1;
		int date=c.get(Calendar.DAY_OF_MONTH);
		int weekday=c.get(Calendar.DAY_OF_WEEK)-1;
		String weekday2=weekday==0?"日":weekday+"";
		
		int hour=c.get(Calendar.HOUR);
		int minute=c.get(Calendar.MINUTE);
		int second=c.get(Calendar.SECOND);
		System.out.println(year+"年"+month+"月"+date+"日"+hour+"时"+minute+"分"+second+"秒"+"  周"+weekday2);
		System.out.printf("%d年%d月%d日,星期%s %d:%d:%d\n", year, month, date,weekday2, hour, minute, second);
	}

}

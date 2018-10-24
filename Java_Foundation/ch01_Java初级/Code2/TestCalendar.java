
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {
	public static void main(String[] args){
		
		//������ڵ����Ԫ��
		Calendar calendar= new GregorianCalendar(2050,10,6,22,6,35);
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH);
		int day=calendar.get(Calendar.DATE); //Ҳ����ʹ�ã�DAY_OF_MONTH
		int weekday=calendar.get(Calendar.DAY_OF_WEEK);//���ڼ���1-7 1�������գ�2������һ���� 7��������
		System.out.println(year);
		System.out.println(month);//0-11 ��ʾ��Ӧ�·�.0��1�·ݣ�����11��12�·�
		System.out.println(weekday);
		System.out.println(day);
		
		//�������ڵ����Ԫ��
		Calendar c2= new GregorianCalendar();  //������ǰʱ�������
		c2.set(Calendar.YEAR,8102);
		c2.set(Calendar.MONTH, 0);
		c2.set(Calendar.DATE, 6);
		c2.set(Calendar.HOUR_OF_DAY,22);
		c2.set(Calendar.MINUTE, 55);
		c2.set(Calendar.SECOND, 40);
		printCalendar(c2);
		//���ڵļ���
		Calendar c3= new GregorianCalendar();  
		c3.add(Calendar.MONTH, 2);
		c3.add(Calendar.DATE, -10);
		System.out.println(c3);
		
		//���������ʱ������ת��
		Date d4= c3.getTime();
		Calendar c4= new GregorianCalendar();
		c4.setTime(new Date());
		printCalendar(c4);
		
	}
	
	public static void printCalendar(Calendar c){   //��ӡ���ڵķ���
		
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH)+1;
		int date=c.get(Calendar.DAY_OF_MONTH);
		int weekday=c.get(Calendar.DAY_OF_WEEK)-1;
		String weekday2=weekday==0?"��":weekday+"";
		
		int hour=c.get(Calendar.HOUR);
		int minute=c.get(Calendar.MINUTE);
		int second=c.get(Calendar.SECOND);
		System.out.println(year+"��"+month+"��"+date+"��"+hour+"ʱ"+minute+"��"+second+"��"+"  ��"+weekday2);
		System.out.printf("%d��%d��%d��,����%s %d:%d:%d\n", year, month, date,weekday2, hour, minute, second);
	}

}

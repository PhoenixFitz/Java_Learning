

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ����ʱ�������ַ���֮��Ļ���ת��
 * DateFormat�������SimpleDateFormatʵ�����ʹ��
 * @author 
 *
 */
public class TestDateFormat {
	public static void main(String[] args) throws ParseException{
		
		//��ʱ������ա���ʽ�ַ���ָ���ĸ�ʽ��ת����Ӧ���ַ���
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM-dd");
		String str = df.format(new Date(40000000));
		System.out.println(str);
		System.out.println(s2.format(new Date()));
        System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date()));
		System.out.println("################");
		//���ַ������ա���ʽ�ַ���ָ���ĸ�ʽ��ת������Ӧ��ʱ�����
		
		DateFormat df2= new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
		Date date=df2.parse("1983��05��10�� 10ʱ46��55��");
		System.out.println(date);
		date=df.parse("2018-10-06 20:15:30");
		System.out.println("date1: "+date);
		String time = "2018-10-06";
        date = s2.parse(time);
        System.out.println("date2: " + date);
        System.out.println("################");
		
		//���������ĸ�ʽ�ַ�,���磺����D����ø�ʱ�������������ݵĵڼ���
		DateFormat df3=new SimpleDateFormat("D");
		String str3=df3.format(new Date());
		System.out.println(str3);
		
				
	}
}

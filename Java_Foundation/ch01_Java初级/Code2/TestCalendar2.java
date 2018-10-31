

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * ���ӻ���������
 * @author
 *
 */
public class TestCalendar2 {
	
	public static void main(String[] args) throws ParseException{
		System.out.println("���������ڣ���ʽ��2020-10-6����");
		Scanner scanner=new Scanner(System.in);
		String str=scanner.nextLine();
		
		// ��������ַ���ת����������
		DateFormat	df=new SimpleDateFormat("yyyy-MM-dd");
		Date date=df.parse(str);
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		int day=c.get(Calendar.DAY_OF_MONTH);
		int days=c.getActualMaximum(Calendar.DATE);   //�洢���µ��������
		
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		c.set(Calendar.DAY_OF_MONTH,1);    //���ô�1�ſ�ʼ
		//ȷ��1�����ܼ�������֮ǰ������ǰ���Ͽո�������1����һ��2����
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
				System.out.println(); 				//��������������������
			}
			c.add(Calendar.DAY_OF_MONTH,1);
		}
	}
}

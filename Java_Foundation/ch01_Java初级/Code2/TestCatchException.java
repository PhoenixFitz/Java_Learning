

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestCatchException {
	 static FileReader reader = null;
	public static void main(String[] args){
	  try{
		 reader = new FileReader("f:/a.txt");
		 System.out.println("step1");
		char c1=(char)reader.read();
		System.out.println(c1);
	  }catch(FileNotFoundException e){    //�����쳣�ڸ����쳣ǰ��
		  System.out.println("step2");
		  e.printStackTrace();
		  
	  } catch (IOException e) {
		e.printStackTrace();
	  }finally{	   //finally��䲻���Ƿ������쳣��������Ҫִ��
		  System.out.println("step3");
		  try {
			  if(reader!=null){
				  reader.close();
			  }		
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	}
}


import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * ����File��
 * @author 
 *
 */
public class TestFile {
	public static void main(String[] args) throws IOException{
		System.out.println(System.getProperty("user.dir"));  //�û�Ŀ¼·��
        File f = new File("a.txt"); //���·����Ĭ�Ϸŵ�user.dirĿ¼����
        
        File f2 = new File("d:/b.txt");//����·��
        f2.createNewFile();    //�����ļ�
        System.out.println("File�Ƿ���ڣ�"+f2.exists());    //true	
        System.out.println("File�Ƿ���Ŀ¼��"+f2.isDirectory()); 	//false
        System.out.println("File�Ƿ����ļ���"+f2.isFile());		//true
        System.out.println("File����޸�ʱ�䣺"+new Date(f2.lastModified()));
        System.out.println("File�Ĵ�С��"+f2.length());  //0
        System.out.println("File���ļ�����"+f2.getName());   //b.txt
        System.out.println("File��Ŀ¼·����"+f2.getPath());	//d:\b.txt
        
        //ʹ��mkdir��mkdirs����Ŀ¼
        
        File f3 = new File("d:/c.txt");
        f3.createNewFile(); // ����d����������c.txt�ļ�
        f3.delete(); // �����ļ���Ŀ¼��Ӳ����ɾ��
        File f4 = new File("d:/��Ӱ/����/��½");
        boolean flag = f4.mkdir(); //Ŀ¼�ṹ����һ�������ڣ��򲻻ᴴ������Ŀ¼��
        System.out.println(flag);//����ʧ��
        boolean flag2 = f4.mkdirs();//Ŀ¼�ṹ����һ��������Ҳû��ϵ����������Ŀ¼��
        System.out.println(flag2);//�����ɹ�
		
	}

}


import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 测试File类
 * @author 
 *
 */
public class TestFile {
	public static void main(String[] args) throws IOException{
		System.out.println(System.getProperty("user.dir"));  //用户目录路径
        File f = new File("a.txt"); //相对路径：默认放到user.dir目录下面
        
        File f2 = new File("d:/b.txt");//绝对路径
        f2.createNewFile();    //创建文件
        System.out.println("File是否存在："+f2.exists());    //true	
        System.out.println("File是否是目录："+f2.isDirectory()); 	//false
        System.out.println("File是否是文件："+f2.isFile());		//true
        System.out.println("File最后修改时间："+new Date(f2.lastModified()));
        System.out.println("File的大小："+f2.length());  //0
        System.out.println("File的文件名："+f2.getName());   //b.txt
        System.out.println("File的目录路径："+f2.getPath());	//d:\b.txt
        
        //使用mkdir和mkdirs创建目录
        
        File f3 = new File("d:/c.txt");
        f3.createNewFile(); // 会在d盘下面生成c.txt文件
        f3.delete(); // 将该文件或目录从硬盘上删除
        File f4 = new File("d:/电影/华语/大陆");
        boolean flag = f4.mkdir(); //目录结构中有一个不存在，则不会创建整个目录树
        System.out.println(flag);//创建失败
        boolean flag2 = f4.mkdirs();//目录结构中有一个不存在也没关系；创建整个目录树
        System.out.println(flag2);//创建成功
		
	}

}

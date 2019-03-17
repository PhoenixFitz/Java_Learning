import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

/**
 * 读取xml文件中的信息
 */
public class TestXml {
    public static void main(String[] args) throws DocumentException {
        //创建 SAXReader对象，用于读取xml文件
        SAXReader reader = new SAXReader();
        //读取xml文件，得到Document对象
        Document doc = reader.read(new File("src/scores3.xml"));
        System.out.println(doc);
        //获取根元素
        Element root =doc.getRootElement();
        System.out.println(((Element) root).getName());
        //获取根元素下所有子元素
        Iterator<Element> it = root.elementIterator(); //类型也可以定义成 Iterator<?>
        while (it.hasNext()){
            //取出元素
            Element e = it.next();
            System.out.println(e.getName());
            //获取id属性
            Attribute id = e.attribute("id");
            System.out.println(id.getName()+"="+id.getValue());
            //获取student子元素
            Element name = e.element("name");
            Element course = e.element("course");
            Element score = e.element("score");
            System.out.println(name.getName()+"="+name.getStringValue());
            System.out.println(course.getName()+"="+course.getText());
            System.out.println(score.getName()+"="+score.getText());
            System.out.println("--------------");
        }
    }
}

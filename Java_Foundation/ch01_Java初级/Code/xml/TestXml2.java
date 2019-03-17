import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import javax.sql.rowset.spi.XmlWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


/**
 * 生成xml文件
 *
 */
public class TestXml2 {
    public static void main(String[] args) throws IOException {
        //通过DocumentHelper生成一个Document对象
        Document doc = DocumentHelper.createDocument();
        //添加并得到根元素
        Element root = doc.addElement("books");
        //为根元素添加子元素
        Element book = root.addElement("book");
        //为book元素添加属性，链式编程
        book.addAttribute("id", "b01");
        //为book元素添加子元素
        Element name = book.addElement("name");
        Element author = book.addElement("author");
        Element price = book.addElement("price");
        //为子元素添加文本
        name.addText("Thinking in Java");
        author.addText("li");
        price.addText("99");
        /*//将doc输出到xml文件中即可
        Writer writer = new FileWriter(new File("src/book2.xml"));
        doc.write(writer);
        //关闭资源
        writer.close(); */

        //格式良好的输出
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileWriter(new File("src/book2.xml")) ,format);
        writer.write(doc);
        //关闭资源
        writer.close();


    }
}

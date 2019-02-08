package com.kl.server;

import com.kl.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 熟悉SAX解析流程
 */
public class XmlTest03 {
    public static void main(String[] args) throws Exception {
        //SAX解析
        //1、获取解析工厂
        SAXParserFactory factory= SAXParserFactory.newInstance();
        //2、从解析工厂获取解析器
        SAXParser parse =factory.newSAXParser();
        //3、编写处理器
        //4、加载文档 Document 注册处理器
        WebHandler handler=new WebHandler();
        //5、解析
        parse.parse(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/kl/server/web.xml"),handler);
        //获取数据
        WebContent content = new WebContent(handler.getEntities(),handler.getMappings());
        //假设输入了/login
        String className = content.getClz("/login");
        Class clz = Class.forName(className);
        Servlet servlet = (Servlet)clz.getConstructor().newInstance();
        System.out.println(servlet);
        servlet.service();

    }
}

class WebHandler extends DefaultHandler{
    private List<Entity> entities;
    private List<Mapping> mappings;
    private Entity entity;
    private Mapping mapping;
    private boolean isMapping = false;
    private String tag; //存储操作的标签
    @Override
    public void startDocument() throws SAXException {
        entities = new ArrayList<Entity>();
        mappings = new ArrayList<Mapping>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName+"-->解析开始");
        if(qName!=null) {
            tag = qName;
            if (tag.equals("servlet")) {
                entity = new Entity();
                isMapping = false;
            }else if(tag.equals("servlet-mapping")){
                mapping = new Mapping();
                isMapping = true;
            }
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (tag != null) {//处理空的情况
            if(isMapping){//操作 servlet-mapping
                if (tag.equals("servlet-name")) {
                    mapping.setName(contents);
                } else if (tag.equals("url-pattern")) {
                    mapping.addPattern(contents);
                }
            }else{//操作servlet
                if (tag.equals("servlet-name")) {
                    entity.setName(contents);
                } else if (tag.equals("servlet-class")) {
                    entity.setClz(contents);
                }
            }

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName+"-->解析结束");
        if(qName!=null) {
            if(qName.equals("servlet")){
                entities.add(entity);
            }else if(qName.equals("servlet-mapping")){
                mappings.add(mapping);
            }
        }
        tag = null;//tag丢弃掉
    }

    @Override
    public void endDocument() throws SAXException {

    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }
}
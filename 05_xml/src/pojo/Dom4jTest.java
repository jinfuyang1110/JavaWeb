package pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Eric
 * @date 2021/1/15 14:07
 */
public class Dom4jTest {
    @Test
    public void getDocument() throws DocumentException {
//        创建一个SAXReader对象
        SAXReader saxReader = new SAXReader();
//        这个对象用于读取xml文件返回一个Document对象
        Document document = saxReader.read("src/books.xml");
//        通过Document的getRootElement方法获取xml的根元素对象
        Element root = document.getRootElement();
//        asSMl（）方法将Element元素转化成String对象
        String xml = root.asXML();
        System.out.println(xml);
        //Element.elements(标签名)它可以拿到当前元素下的指定的子元素的集合
        List<Element> books = root.elements("book");
        for(Element book:books){
            Element name = book.element("name");
            //拿到起始标签和结束标签之间的文本内容
            String price = book.elementText("price");
            Element author = book.element("author");
            String sn = book.attributeValue("sn");
            System.out.printf("书名：%s\n价格：%s\n作者:%s\n",name.getText(),price,author.getText());
            System.out.println(new Book(sn,name.getText(),new BigDecimal(price),author.getText()));
        }
    }
}

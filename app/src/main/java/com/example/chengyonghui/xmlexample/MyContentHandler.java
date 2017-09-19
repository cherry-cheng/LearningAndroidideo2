package com.example.chengyonghui.xmlexample;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by chengyonghui on 2017/9/18.
 */
public class MyContentHandler extends DefaultHandler {
    String hisname, address, money, sex, status;
    String tagName;

    public void startDocument() throws SAXException {
        System.out.println("------------begin----------------");
    }

    public void endDocument() throws SAXException {
        System.out.println("-----------------end-------------------------");
    }
    //adb:name
    // localname不带前缀
    //qName名称前缀
    public void startElement(String namespaceURI, String localName,
                             String qName, org.xml.sax.Attributes attrs) throws SAXException {
        tagName = localName;
        if (localName.equals("worker")) {
            //获取标签的全部属性
            for (int i = 0; i < attrs.getLength(); i++) {
                System.out.println(attrs.getLocalName(i) + "=" + attrs.getValue(i));
            }
        }
    }

    public void endElement(String namespaceURI, String localName, String qName)
            throws SAXException {
        if (localName.equals("worker")) {
            //worker标签读取完之后打印里面所有的内容
            System.out.println("worker");
        }
    }

    //ch读取到的内容
    public void characters(char[] ch, int start, int length)
        throws SAXException {
        if (tagName.equals("name"))
            hisname = new String(ch, start, length);
        else if (tagName.equals("sex")) {
            sex = new String(ch, start, length);
        } else if (tagName.equals("status")) {
            status = new String(ch, start, length);
        } else if (tagName.equals("address")) {
            address = new String(ch, start, length);
        } else if (tagName.equals("money")) {
            money = new String(ch, start, length);
        }
    }

}

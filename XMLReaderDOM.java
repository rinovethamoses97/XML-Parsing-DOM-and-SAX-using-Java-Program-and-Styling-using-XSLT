import javax.xml.parsers.*;
import java.io.*;
import org.w3c.dom.*;
public class XMLReaderDOM {

    public static void main(String[] args) throws Exception {
        File f=new File("employee.xml");
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
        Document doc=db.parse(f);
        System.out.println("Root Element is"+doc.getDocumentElement().getNodeName());
        NodeList list=doc.getElementsByTagName("Employee");
        for(int i=0;i<list.getLength();i++){
        	Element e=(Element)list.item(i);
        	Element e1=(Element)e.getElementsByTagName("name").item(0);
        	System.out.print("Emplyee Age"+e1.getAttribute("age"));
        	Element n=(Element)e.getElementsByTagName("name").item(0);
        	System.out.print("Emplyee Name"+n.getNodeName());
        }       
    }
}
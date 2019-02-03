import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
public class XMLReaderSAX{
    public static void main(String[] arg) throws Exception{
        File f=new File("employee.xml");

        SAXParserFactory bf=SAXParserFactory.newInstance();
        SAXParser p=bf.newSAXParser();
        Userhandler u=new Userhandler();
        p.parse(f,u);

    }
}
class Userhandler extends DefaultHandler{
    boolean name;
    boolean age;
    boolean role;
    boolean gender;
    public void startElement(String uri,String localname,String qname,Attributes attributes){
        if(qname.equals("name")){
            name=true;
            System.out.print("Age ="+attributes.getValue("age"));
        }
        else if(qname.equals("role"))
            role=true;
    }
    public void endElement(String uri,String localname,String qname){
        // System.out.print(qname);
    }
    public void characters(char ch[],int start,int length){
        if(name){
            name=false;
            String temp=new String(ch,start,length);
            System.out.println("Name="+temp);
        }
        if(role){
            role=false;
            String temp=new String(ch,start,length);
            System.out.println("Role="+temp);   
        }
    }

}
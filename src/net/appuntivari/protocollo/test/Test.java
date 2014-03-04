package net.appuntivari.protocollo.test;
import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import net.appuntivari.protocollo.Libri;
import net.appuntivari.protocollo.Libri.Libro;


public class Test {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Libri.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("./file/libri2.xml");
        
        //XML to Java Classes
        Libri libri = (Libri) unmarshaller.unmarshal(xml);

        for (Libro item : libri.getLibro()) {
        	  System.out.println(item.getTitolo());
        	  System.out.println(item.getAutore());
        	  System.out.println("-----------------");
		}
      
        //Java Classes to XML
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        marshaller.marshal(libri, System.out);
        
        System.out.println("");
        
        StringWriter sw = new StringWriter();
        marshaller.marshal(libri, sw);
        System.out.println(sw);
    }

}
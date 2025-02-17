package supermarket.parsers;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import supermarket.model.Supermarket;

import java.io.File;

public class XMLParserJAXB {
    public static void main(String[] args) {

        try {
            File file = new File("src/main/resources/supermarket.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Supermarket.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Supermarket supermarket = (Supermarket) jaxbUnmarshaller.unmarshal(file);

            System.out.println(supermarket);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

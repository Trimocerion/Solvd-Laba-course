package supermarket.parsers;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class XMLParser {

    public static void main(String[] args) {

        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("src/main/resources/supermarket.xsd"));

            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(new File("src/main/resources/supermarket.xml")));

            XMLInputFactory XMLfactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = XMLfactory.createXMLStreamReader(new FileReader("src/main/resources/supermarket.xml"));

            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    if ("store".equals(reader.getLocalName())) {
                        System.out.print("Store ID: " + reader.getAttributeValue(null, "id") + " ");
                        System.out.print("Address: " + reader.getAttributeValue(null, "address") + " ");
                        System.out.print("Postal Code: " + reader.getAttributeValue(null, "postal_code") + "\n");
                        System.out.println("--------------------");
                    } else if ("product".equals(reader.getLocalName())) {
                        System.out.print("Product ID: " + reader.getAttributeValue(null, "id") + " ");
                        System.out.print("Name: " + reader.getAttributeValue(null, "name") + " ");
                        System.out.print("Price: " + reader.getAttributeValue(null, "price") + "\n");
                        System.out.println("--------------------");
                    } else if ("customer".equals(reader.getLocalName())) {
                        System.out.print("Customer ID: " + reader.getAttributeValue(null, "id") + " ");
                        System.out.print("First Name: " + reader.getAttributeValue(null, "first_name") + " ");
                        System.out.print("Last Name: " + reader.getAttributeValue(null, "last_name") + " ");
                        System.out.print("Email: " + reader.getAttributeValue(null, "email") + "\n");
                        System.out.println("--------------------");
                    } else if ("user".equals(reader.getLocalName())) {
                        System.out.print("User ID: " + reader.getAttributeValue(null, "id") + " ");
                        System.out.print("Username: " + reader.getAttributeValue(null, "username") + " ");
                        System.out.print("Email: " + reader.getAttributeValue(null, "email") + " ");
                        System.out.print("Password: " + reader.getAttributeValue(null, "password") + "\n");
                        System.out.println("--------------------");
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
}


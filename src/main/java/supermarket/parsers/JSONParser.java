package supermarket.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import supermarket.model.Supermarket;

import java.io.File;

public class JSONParser {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            Supermarket supermarket = mapper.readValue(new File("src/main/resources/supermarket.json"), Supermarket.class);

            System.out.println(supermarket);

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

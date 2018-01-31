package by.itiacademy.parser;

import by.itiacademy.dowloader.FileDownloader;
import by.itiacademy.entity.Owner;
import by.itiacademy.exception.FileParsingException;
import by.itiacademy.parser.common.Parser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParser implements Parser {

    private static JsonParser instance;

    private JsonParser() {
    }

    public static JsonParser getInstance() {
        if (instance == null) {
            synchronized (JsonParser.class) {
                if (instance == null) {
                    instance = new JsonParser();
                }
            }
        }
        return instance;
    }

    @Override
    public Owner parse() throws FileParsingException {
        try {
//            FileDownloader fileDownloader = FileDownloader.getInstance();
//            File download = fileDownloader.download("http://kiparo.ru/t/bank_card.json", "bank_card.json");
//            System.out.println(download.getAbsoluteFile());
            byte[] bytes = Files.readAllBytes(Paths.get("C:\\Users\\Asus\\Documents\\final-task\\hao-final-task\\bank_card.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            Owner owner = objectMapper.readValue(bytes, Owner.class);
            return owner;

        } catch (Exception e) {
            throw new FileParsingException("ERROR WHILE PARSING FILE " + e);
        }
    }

//    public static void main(String[] args) throws FileParsingException {
//        JsonParser jsonParser = new JsonParser();
//        jsonParser.parse();
//    }
}

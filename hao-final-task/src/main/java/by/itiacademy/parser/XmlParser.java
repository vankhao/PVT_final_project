package by.itiacademy.parser;

import by.itiacademy.dowloader.FileDownloader;
import by.itiacademy.entity.Owner;
import by.itiacademy.exception.FileParsingException;
import by.itiacademy.parser.common.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlParser implements Parser {

    private static XmlParser instance;

    private XmlParser() {
    }

    public static XmlParser getInstance() {
        if (instance == null) {
            synchronized (XmlParser.class) {
                if (instance == null) {
                    instance = new XmlParser();
                }
            }
        }
        return instance;
    }

    @Override
    public Owner parse() throws FileParsingException {
        try {
            FileDownloader fileDownloader = FileDownloader.getInstance();
            File download = fileDownloader.download("http://kiparo.ru/t/bank_card.xml", "bank_card.xml");

            JAXBContext context = JAXBContext.newInstance(Owner.class);
            Unmarshaller un = context.createUnmarshaller();
            Owner emp = (Owner) un.unmarshal(download.getAbsoluteFile());
            System.out.println(emp);
            return emp;
        } catch (Exception e) {
            throw new FileParsingException("ERROR WHILE PARSING FILE: " + e);
        }
    }


//    public static void main(String[] args) throws FileParsingException {
//        XmlParser xmlParser = new XmlParser();
//        Owner parse = xmlParser.parse();
//    }


}

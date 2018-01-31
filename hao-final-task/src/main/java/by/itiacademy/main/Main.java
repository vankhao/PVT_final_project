package by.itiacademy.main;

import by.itiacademy.entity.Card;
import by.itiacademy.entity.Owner;
import by.itiacademy.exception.OperationException;
import by.itiacademy.operation.CardOperation;
import by.itiacademy.parser.JsonParser;
import by.itiacademy.parser.XmlParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonParser jsonParser = JsonParser.getInstance();
        XmlParser xmlParser = XmlParser.getInstance();
        CardOperation cardOperation = CardOperation.getInstance();
        Owner result = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice = null;
        printInfoMessage();

        /**
         * This method was created for choice operations
         * @throws IOException
         */

        try {
            choice = reader.readLine().trim();
            if (choice.equalsIgnoreCase("1")) {
                result = jsonParser.parse();
                System.out.println(result);
            }
            if (choice.equalsIgnoreCase("2")) {
                result = xmlParser.parse();
                System.out.println(result);
            }

        } catch (Exception e) {
            throw new OperationException("ERROR WHILE WORKING WITH CONSOLE");
        }

        if (result != null) {
            printOperationInfo();
            List<Card> cardsOfOwner = result.getCardsOfOwner();
            choice = reader.readLine().trim();
            if (choice.equalsIgnoreCase("1")) {
                System.out.println("Введите название банка Латинскими буквами: ");
                choice = reader.readLine().trim();
                Card card = cardOperation.filterByBankName(cardsOfOwner, choice);
                if (card == null) {
                    System.out.println("По вашему запросу ничего не найдено");
                }
                System.out.println("По вашему запросу найдена карта: " + card);
            }
            if (choice.equalsIgnoreCase("2")) {
                System.out.println("Введите ид карты: ");
                choice = reader.readLine().trim();
                Card card = cardOperation.filterById(cardsOfOwner, Long.valueOf(choice));
                if (card == null) {
                    System.out.println("По вашему запросу ничего не найдено");
                }
                System.out.println("По вашему запросу найдена карта: " + card);
            }
            if (choice.equalsIgnoreCase("3")) {
                System.out.println("Сортирю по годам....");
                List<Card> cards = cardOperation.sortByYear(cardsOfOwner);
                cards.forEach(System.out::println);
            }
        }


    }

    private static void startOperation(String oper) {

    }

    private static void printInfoMessage() {
        System.out.println("Приветствует Вас! Это система UR Wallet");
        System.out.println("------------ヽ(•‿•)ノ---------------------");
        System.out.println("Данная система позволяет Вас скачать данные из интернета и выполнить никоторые простые операции с данными.");
        System.out.println("Чтобы загрузить данные, выберите вашу операцию: ");
        System.out.println("=========================================================================================================== ");
        System.out.println("Введите 1, чтобы загрузить данные из формата json");
        System.out.println("Введите 2, чтобы загрузить данные из формата xml");
        System.out.println("---------------------------------------------------- ");
    }

    private static void printOperationInfo() {
        System.out.println();
        System.out.println();
        System.out.println("Выберите Ваши операции: ");
        System.out.println();
        System.out.println("1) Поиск карты по названию банка");
        System.out.println("2) Поиск карты по ID");
        System.out.println("3) Выполнить сортировку по годам");
        System.out.println("0) Выход из программы");
        System.out.println("Введите номер операции: ");
    }

}

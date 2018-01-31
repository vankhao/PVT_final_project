package by.itiacademy.operation;

import by.itiacademy.entity.Card;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CardOperation {

    private static CardOperation instance;

    private CardOperation() {
    }

    public static CardOperation getInstance() {
        if (instance == null) {
            synchronized (CardOperation.class) {
                if (instance == null) {
                    instance = new CardOperation();
                }
            }
        }
        return instance;
    }


    public Card filterByBankName(final List<Card> cards, final String name) {
        return cards.stream()
                .filter(card -> card.getName().equalsIgnoreCase(name))
                .findAny().orElse(null);
    }

    public Card filterById(final List<Card> cards, final Long id) {
        return cards.stream().filter(card -> card.getId().equals(id)).findAny().orElse(null);
    }


    public List<Card> sortByYear(List<Card> cards) {
        Comparator<Card> compareByYear = Comparator.comparingInt(c -> c.getYear().getYear());
        return cards.stream().sorted(compareByYear).collect(Collectors.toList());

    }
}

package model.card;

import java.util.ArrayList;
import java.util.List;

public class PokerHand implements IHand {
    private final List<ICard> cards = new ArrayList<>();
    private static final int numberOfCards = 2;

    public PokerHand(ICard card1, ICard card2) {
        this.cards.add(card1);
        this.cards.add(card2);
    }

    @Override
    public ICard getCard(int cardIndex) {
        try {
            return cards.get(cardIndex);
        }
        catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return cards.get(0);
        }
    }

    @Override
    public List<ICard> getAllCards() {
        return this.cards;
    }

    @Override
    public String toString() {
        return "PokerHand{" +
                "cards=" + cards +
                '}';
    }
}

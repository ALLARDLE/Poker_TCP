package Cards;

import java.util.LinkedList;
import java.util.List;

public class PokerDeck implements IDeck {
    private List<ICard> cards = new LinkedList<>();
    private int numberOfCardsLeft;

    public PokerDeck() throws ColorException, ValueException {
        for (PokerColor.Colors pokerColors : PokerColor.Colors.values()) {
            for (PokerValue.Values pokerValues : PokerValue.Values.values()) {
                cards.add(new PokerCard(new PokerColor(pokerColors), new PokerValue(pokerValues)));
            }
        }
        numberOfCardsLeft = cards.size();
    }

    public int getNumberOfCardsLeft() {
        return numberOfCardsLeft;
    }

    public List<ICard> getCards() {
        return cards;
    }

    public void createDeck()    {
    }

    public ICard removeCard(ICard card) throws Exception {
        for (int i=0; i<numberOfCardsLeft; i++) {
            if(cards.get(i) == card) return card;
        }
        throw new Exception("Error");
    }

    @Override
    public String toString() {
        return "PokerDeck{" +
                "\n\tlength : " + numberOfCardsLeft +
                "\n\tcards : " + cards +
                '}';
    }
}

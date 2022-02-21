package Cards;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PokerDeck implements IDeck {
    private List<ICard> cards = new LinkedList<>();
    private int numberOfCardsLeft;

    public PokerDeck() throws ColorException, ValueException {
        resetDeck();
        setDeck();
        shuffle();
    }

    public int getNumberOfCardsLeft() {
        return numberOfCardsLeft;
    }

    /**
     * Méthode permettant de tirer des cartes. Les cartes sont supprimées de la liste
     */
    public List<ICard> getCards(int numberOfCards) {

        List<ICard> returnCards = new LinkedList<>();
        if (numberOfCards > numberOfCardsLeft)  numberOfCards = numberOfCardsLeft;
        for (int i=0; i<numberOfCards; i++) {
            numberOfCardsLeft--;
            returnCards.add(this.cards.remove(1));
        }
        return returnCards;
    }

    public void resetDeck() {
        this.cards.clear();
        this.numberOfCardsLeft = 0;
    }

    public void setDeck() throws ColorException, ValueException {
        for (PokerColor.Colors pokerColors : PokerColor.Colors.values()) {
            for (PokerValue.Values pokerValues : PokerValue.Values.values()) {
                cards.add(new PokerCard(new PokerColor(pokerColors), new PokerValue(pokerValues)));
            }
        }
        numberOfCardsLeft = cards.size();
    }

    public ICard removeCard(ICard card) throws Exception {
        for (int i=0; i<numberOfCardsLeft; i++) {
            if(cards.get(i) == card)    {
                numberOfCardsLeft--;
                return cards.remove(i);
            }
        }
        throw new Exception("Error");
    }

    public void shuffle()   {
        Collections.shuffle(this.cards);
    }

    @Override
    public String toString() {
        return "PokerDeck{" +
                "\n\tlength : " + numberOfCardsLeft +
                "\n\tcards : " + cards +
                '}';
    }
}

package Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerDeck implements IDeck {
    private List<ICard> cards = new ArrayList<>();
    private int numberOfCardsLeft;

    public PokerDeck() {
        numberOfCardsLeft = 0;
    }

    public PokerDeck(List<ICard> cards) {
        this.cards = cards;
        numberOfCardsLeft = cards.size();
    }

    public int getNumberOfCardsLeft() {
        return numberOfCardsLeft;
    }

    public List<ICard> getDeck ()    {
        return cards;
    }
    @Override
    public void addCard(ICard card)   {
        cards.add(card);
        numberOfCardsLeft++;
    }

    @Override
    public void addCards(List<ICard> cards) {
        for (ICard c : cards)   {
            addCard(c);
        }
    }

    @Override
    public ICard getCard() {
        if (numberOfCardsLeft != 0) {
            numberOfCardsLeft--;
            return cards.remove(0);
        }
        else return null;
    }

    @Override
    public List<ICard> getCards(int numberOfCards) {
        List<ICard> returnCards = new ArrayList<>();
        if (numberOfCards > numberOfCardsLeft)  numberOfCards = numberOfCardsLeft;
        for (int i=0; i<numberOfCards; i++) {
            returnCards.add(getCard());
        }
        return returnCards;
    }


    @Override
    public void setDeck() {
        for (PokerColor.Colors pokerColors : PokerColor.Colors.values()) {
            for (PokerValue.Values pokerValues : PokerValue.Values.values()) {
                cards.add(new PokerCard(new PokerColor(pokerColors), new PokerValue(pokerValues)));
            }
        }
        numberOfCardsLeft = cards.size();
    }

    @Override
    public void resetDeck() {
        this.cards.clear();
        this.numberOfCardsLeft = 0;
    }



    @Override
    public ICard removeCard(ICard card) throws Exception {
        for (int i=0; i<numberOfCardsLeft; i++) {
            if (cards.get(i).equals(card))  {
                numberOfCardsLeft--;
                return cards.remove(i);
            }
        }
        throw new Exception("This card not existing");
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

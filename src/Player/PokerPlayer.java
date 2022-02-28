package Player;

import Cards.*;

import java.util.ArrayList;
import java.util.List;

public class PokerPlayer implements IPlayer {

    private final String playerName;
    private final IDeck playerDeck;

    public PokerPlayer(String name, IDeck deck) {
        this.playerName = name;
        this.playerDeck = deck;
    }

    @Override
    public String getName() {
        return playerName;
    }

    @Override
    public ICard getCard() {
        return playerDeck.getCard();
    }

    @Override
    public List<ICard> getCards(int nbCards) {
        return playerDeck.getCards(nbCards);
    }

    @Override
    public int getNumberOfCardsLeft() {
        return playerDeck.getNumberOfCardsLeft();
    }

    @Override
    public void shuffleCards() {
        playerDeck.shuffle();
    }

    @Override
    public void addCard(ICard card)   {
        playerDeck.addCard(card);
    }

    @Override
    public void addCards(List<ICard> cards) {
        playerDeck.addCards(cards);
    }

    @Override
    public String toString() {
        return "PokerPlayer{" +
                "playerName='" + playerName + '\'' +
                ", playerDeck=" + playerDeck +
                '}';
    }
}

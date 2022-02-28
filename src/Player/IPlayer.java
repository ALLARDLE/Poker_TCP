package Player;

import Cards.ICard;

import java.util.List;

public interface IPlayer {
    String getName();

    void addCard(ICard card);
    void addCards(List<ICard> cards);

    ICard getCard();
    List<ICard> getCards(int nbCards);

    int getNumberOfCardsLeft();
    void shuffleCards();
}

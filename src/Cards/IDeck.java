package Cards;

import java.util.List;

/**
 * @author Allard Léni & Billon François
 *
 * Classe pour la gestion du paquet de cartes.
 * Elle doit pouvoir générer toutes les cartes et les mélanger.
 */

public interface IDeck {
    int getNumberOfCardsLeft();
    void addCard(ICard card);
    void addCards(List<ICard> cards);
    List<ICard> getDeck();
    ICard getCard();
    List<ICard> getCards(int numberOfCards);
    ICard removeCard(ICard card) throws Exception;
    void shuffle();
    void setDeck();
    void resetDeck();
}

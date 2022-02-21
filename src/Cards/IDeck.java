package Cards;

import java.util.List;

/**
 * @author Allard Léni & Billon François
 *
 * Classe pour la gestion du paquet de cartes.
 * Elle doit pouvoir générer toutes les cartes et les mélanger.
 */

interface IDeck {
    int getNumberOfCardsLeft();
    List<ICard> getCards(int numberOfCards);
    ICard removeCard(ICard card) throws Exception;
    void shuffle();
    void setDeck() throws ColorException, ValueException;
    void resetDeck();
}

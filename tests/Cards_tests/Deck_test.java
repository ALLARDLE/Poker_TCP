package Cards_tests;

import model.card.PokerCard;
import model.card.PokerColor;
import model.card.PokerDeck;
import model.card.PokerValue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Deck_test {
    @Test
    public void testEquals() {
        PokerDeck deck = new PokerDeck();
        assertEquals(52, deck.getNumberOfCardsLeft());

        PokerCard c1 = (PokerCard) deck.getCards(1).get(0);
        PokerCard c2 = new PokerCard(new PokerColor(PokerColor.Colors.HEART), new PokerValue(PokerValue.Values.TWO));
        assertEquals(51, deck.getNumberOfCardsLeft());
        assertEquals(c2, c1);
        deck.shuffle();

        deck.getCards(10);
        assertEquals(41, deck.getNumberOfCardsLeft());

        deck.getCards(100);
        assertEquals(0, deck.getNumberOfCardsLeft());

        deck.setDeck();
        assertEquals(52, deck.getNumberOfCardsLeft());

        try {
            PokerCard c3 = (PokerCard) deck.removeCard(c2);
            assertEquals(c2, c3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

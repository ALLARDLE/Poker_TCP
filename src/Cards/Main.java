package Cards;

import java.util.concurrent.SynchronousQueue;

public class Main {

    public static void main(String[] args) {
        try {
            PokerValue valueCard = new PokerValue(PokerValue.Values.ACE);
            System.out.println(valueCard);

            PokerColor colorCard = new PokerColor(PokerColor.Colors.CLUB);
            System.out.println(colorCard);

            ICard card = new PokerCard(colorCard, valueCard);
            System.out.println(card);

            IDeck deck = new PokerDeck();
            System.out.println(deck);

        } catch (ValueException | ColorException e) {
            e.printStackTrace();
        }
    }
}

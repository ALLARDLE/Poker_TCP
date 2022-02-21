package Cards;


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

            PokerCard rmCard = (PokerCard) deck.removeCard(card);
            System.out.println(rmCard);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

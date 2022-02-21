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
            deck.shuffle();

            Hand h1 = new Hand(deck.getCards(5));
            System.out.println(h1);

            System.out.println(h1.getCards().get(0));
            System.out.println(h1.getCards().get(1));

            System.out.println(h1.getCards().get(0).isUpperTo(h1.getCards().get(1)));



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

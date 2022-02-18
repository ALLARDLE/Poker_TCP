package Cards;

public class Main {

    public static void main(String[] args) {
        try {
            PokerValue valueCard = new PokerValue(PokerValue.Values.ACE);
            System.out.println(valueCard);

            PokerColor colorCard = new PokerColor(PokerColor.PokerColors.CLUB);
            System.out.println(colorCard);

            ICard card = new PokerCard(colorCard, valueCard);
            System.out.println(card);

        } catch (ValueException | ColorException e) {
            e.printStackTrace();
        }
    }
}

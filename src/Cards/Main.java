package Cards;

public class Main {

    public static void main(String[] args) {
        try {
            Value valueCard = new Value(Value.Values.ACE);
            System.out.println(valueCard);

            PokerColor colorCard = new PokerColor(PokerColor.PokerColors.CLUB);
            System.out.println(colorCard);

            Card card = new Card(colorCard, valueCard);
            System.out.println(card);

        } catch (ValueException | ColorException e) {
            e.printStackTrace();
        }
    }
}

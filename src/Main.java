import model.card.*;
import model.player.IPlayer;
import model.player.PokerPlayer;

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

            IHand h1 = new PokerHand(deck.getCard(), deck.getCard());
            IHand h2 = new PokerHand(deck.getCard(), deck.getCard());

            System.out.println(h1);
            System.out.println(h2);

            IPlayer player1 = new PokerPlayer("Toto", 1000);
            player1.setHand(h1);

            System.out.println(player1);

            /**
            System.out.println("Nouveau jeu");
            PokerGame game = new PokerGame(3);

            System.out.println(game.getPlayers());
            game.run();     // lance le jeu
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

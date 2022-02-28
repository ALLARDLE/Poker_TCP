package Cards;

import Game.PokerGame;

import java.util.concurrent.TimeUnit;

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

            Hand h1 = new Hand(deck.getCards(26));
            Hand h2 = new Hand(deck.getCards(26));

            System.out.println(h1);
            System.out.println(h2);

            System.out.println("\n");
            System.out.println(h1.getCards().get(0));
            System.out.println(h1.getCards().get(1));

            System.out.println(h1.getCards().get(0).isUpperTo(h1.getCards().get(1)));


            System.out.println("Nouveau jeu");
            PokerGame game = new PokerGame("Joueur1", "Joueur2");

            System.out.println(game.getPlayer1());
            System.out.println(game.getPlayer2());

            game.run();     // lance le jeu

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

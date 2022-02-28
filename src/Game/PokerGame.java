package Game;

import Cards.ColorException;
import Cards.IDeck;
import Cards.PokerDeck;
import Cards.ValueException;
import Player.IPlayer;
import Player.PokerPlayer;

public class PokerGame {
    IPlayer player1;
    IPlayer player2;
    int nbTour = 1;
    String playerTour;

    public PokerGame(String name1, String name2) throws ColorException, ValueException {
        // création des cartes
        IDeck deck1 = new PokerDeck();
        deck1.shuffle();

        IDeck deck2 = new PokerDeck(deck1.getCards((int) deck1.getNumberOfCardsLeft() / 2));

        // création des joueurs
        player1 = new PokerPlayer(name1, deck1);
        player2 = new PokerPlayer(name2, deck2);
    }

    public void run()  {
        System.out.print("Tour : ");
        System.out.println(nbTour);
        
    }


}

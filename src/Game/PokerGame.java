package Game;

import Cards.*;
import Player.IPlayer;
import Player.PokerPlayer;

import java.util.ArrayList;
import java.util.List;

public class PokerGame {
    private IPlayer player1;
    private IPlayer player2;
    private int nbTour = 1;
    private List<ICard> pot = new ArrayList<>();

    public PokerGame(String name1, String name2) throws ColorException, ValueException {
        // création des cartes
        IDeck deck1 = new PokerDeck();
        deck1.shuffle();

        IDeck deck2 = new PokerDeck(deck1.getCards((int) deck1.getNumberOfCardsLeft() / 2));

        // création des joueurs
        player1 = new PokerPlayer(name1, deck1);
        player2 = new PokerPlayer(name2, deck2);
    }

    public void run() throws Exception {
        while (true) {
            System.out.print("Tour : ");
            System.out.println(nbTour);
            if (player1.getNumberOfCardsLeft() == 0) {
                // joueur 2 a gagné
                System.out.print("Victoire joueur 2 en ");
                System.out.print(nbTour);
                System.out.println(" tours");
                break;
            } else if (player2.getNumberOfCardsLeft() == 0) {
                // Joueur 1 a gagné
                System.out.println("Victoire joueur 1");
                System.out.print(nbTour);
                System.out.println(" tours");
                break;
            } else {
                turn();
            }

            nbTour++;
        }
    }

    public void turn() throws Exception {
        // TODO vérifier qu'il reste des cartes chez les joueurs
        ICard c1 = player1.getCard();
        pot.add(c1);
        System.out.print("Joueur 1 : ");
        System.out.println(c1);

        ICard c2 = player2.getCard();
        pot.add(c2);
        System.out.print("Joueur 2 : ");
        System.out.println(c2);


        // comparaison des cartes
        if (c1.isUpperTo(c2) > 0)   {
            // p1 a gagné
            System.out.println("Joueur 1 gagne");
            player1.addCards(pot);
            pot.clear();
        }
        else if (c1.isUpperTo(c2) < 0)  {
            System.out.println("Joueur 2 gagne");
            player2.addCards(pot);
            pot.clear();
        }
        else    {
            System.out.println("Egalite");
            // on "brule" une carte pour chaque joueur
            pot.add(player1.getCard());
            pot.add(player2.getCard());
            turn();     // on repart sur un tour
        }
    }

    public int getNbTour() {
        return nbTour;
    }

    @Override
    public String toString() {
        return "PokerGame{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                ", nbTour=" + nbTour +
                ", pot=" + pot +
                '}';
    }

    public IPlayer getPlayer1() {
        return player1;
    }

    public IPlayer getPlayer2() {
        return player2;
    }
}

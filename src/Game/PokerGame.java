package Game;

import Cards.*;
import Player.IPlayer;
import Player.PokerPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokerGame {
    private final List<IPlayer> players = new ArrayList<>();
    private int nbTour = 1;
    private final IDeck deck = new PokerDeck();

    public PokerGame(int nbPlayer) throws ColorException, ValueException {
        // création des joueurs
        Scanner input = new Scanner(System.in);
        for(int i=0; i<nbPlayer; i++)   {
            System.out.print("Username ");
            System.out.print(i+1);
            System.out.print(" : ");
            String userName = input.nextLine();
            players.add(new PokerPlayer(userName));
        }

        // création des cartes
        deck.shuffle();
        distributeAllCards();
    }

    private void distributeCards(int nbCards)   {
        int index = 0;
        if (nbCards > deck.getNumberOfCardsLeft())  {
            distributeAllCards();
        }
        else {
            for (int i = 0; i < nbCards; i++) {
                players.get(index % players.size()).addCard(deck.getCard());
                index++;
            }
        }
    }

    private void distributeAllCards()   {
        int index = 0;
        for (ICard card: deck.getCards(deck.getNumberOfCardsLeft()))    {
            players.get(index % players.size()).addCard(card);
            index++;
        }
    }

    public void run() throws Exception {
        while (true) {
            System.out.print("Tour : ");
            System.out.println(nbTour);
            for (IPlayer player: players)   {
                if (player.getNumberOfCardsLeft() == 0) {
                    players.remove(player);
                    System.out.print("Le joueur ");
                    System.out.print(player.getName());
                    System.out.println(" a perdu");
                }
            }
            turn();
            nbTour++;
        }
    }

    public void turn() throws Exception {
        // TODO vérifier qu'il reste des cartes chez les joueurs
        for (IPlayer player: players)   {
            ICard card = player.getCard();
            deck.addCard(card);

            System.out.print("Le joueur ");
            System.out.print(player.getName());
            System.out.println(" a perdu");

        }
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

    /**
     *
     * @return
     * @throws IndexOutOfBoundsException
     */
    public List<ICard> getOneCardPerPlayer() throws IndexOutOfBoundsException   {

        ICard c1 = player1.getCard();
        ICard c2 = player1.getCard();
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

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

    public PokerGame(int nbPlayer) {
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
        deck.setDeck();
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
        while(deck.getNumberOfCardsLeft() > 0)  {
            players.get(index % players.size()).addCard(deck.getCard());
            index++;
        }
    }

    public void run() {
        while (players.size() > 1) {
            System.out.print("\nTour : ");
            System.out.println(nbTour);
            turn();
            nbTour++;
        }
    }

    public void turn() {
        List<ICard> cards = drawCards();    // récupère une carte pour chaque joueur

        // comparaison des cartes
        int index = compareCards(cards);      // index de la personne ayant gagné

        if (index == -1)    {             // égalité
            System.out.println("Égalité");
            drawCards();            // on tire de nouveau des cartes
        }
        else {
            System.out.print("Joueur ");
            System.out.print(players.get(index).getName());
            System.out.println(" gagne");

            players.get(index).addCards(cards);       // ajoute les cartes du pot au joueur ayant gagné la manche
            cards.clear();        // vide le pot
        }
    }

    private int compareCards(List<ICard> cards)   {
        return 0;
    }

    private List<ICard> drawCards()    {
        List<ICard> cards = new ArrayList<>();
        for (IPlayer player: players)   {
            if (player.getNumberOfCardsLeft() == 0) {
                players.remove(player);
                System.out.print("Le joueur ");
                System.out.print(player.getName());
                System.out.println(" a perdu");
            }
            else    {
                ICard card = player.getCard();
                cards.add(card);
                System.out.print("Le joueur ");
                System.out.print(player.getName());
                System.out.print(" a tiré : ");
                System.out.println(card);
            }
        }
        return cards;
    }

    public int getNbTour() {
        return nbTour;
    }


    @Override
    public String toString() {
        return "PokerGame{" +
                "players=" + players +
                ", nbTour=" + nbTour +
                '}';
    }

    public List<IPlayer> getPlayers() {
        return players;
    }
}

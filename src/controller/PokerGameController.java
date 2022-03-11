package controller;


import Cards.Player;
import model.card.IDeck;
import model.card.PokerDeck;
import model.player.IPlayer;

import java.util.List;

/**
 * Joue le rôle du croupier :
 * Accepte les joueurs à la table, donne l'ordre de distribuer les cartes, prend en compte les mises, ...
 */
public class PokerGameController {
    private IDeck deck;
    private IScoreController scoreController;
    private ICardController cardController;
    private PokerPlayerController playerController;
    private RoundController roundController;

    private final static int maxPlayers = 6;


    public PokerGameController(List<IPlayer> pls)  {
        deck = new PokerDeck();     // création du jeu de cartes
        deck.shuffle();     // mélange des cartes
        scoreController = new PokerScoreController(pls, 10);
        cardController = new CardController(pls, deck);
        playerController = new PokerPlayerController(pls);
        roundController = new RoundController(pls, scoreController, cardController);
    }

    /**
     * Gestion des joueurs
     * Gestion des cartes
     * Gestion de l'argent des joueurs
     * Gestion d'un tour
     */
    public void init()   {
        // Distribue les cartes
        cardController.dealPlayerHand();

    }

    public void addPlayer(IPlayer pl)    {
        playerController.addPlayer(pl);
    }
    public void removePlayer(IPlayer pl)    {
        playerController.removePlayer(pl);
    }
}

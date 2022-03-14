package controller;


import model.card.PokerDeck;
import model.player.IPlayer;

import java.util.List;

/**
 * Cette classe centralise toutes les actions sur le table.
 * Elle centralise donc :
 *      - la distribution des cartes (CardController)
 *      - le contrôle des joueurs (PokerPlayerController) ajoute et supprime les joueurs à la table
 *      - la gestion de l'argent sur la table (PokerMoneyController) définit les blindes, les mises à effectuer, ...
 *      - la gestion des tours (RoundController)
 *
 */

public class PokerGameController {

    private IScoreController scoreController;
    private ICardController cardController;
    private PokerPlayerController playerController;
    private RoundController roundController;

    private final static int maxPlayers = 6;


    public PokerGameController(List<IPlayer> pls)  {
        scoreController = new PokerMoneyController(pls, 10);
        cardController = new CardController(new PokerDeck());
        playerController = new PokerPlayerController(pls);
        roundController = new RoundController(pls, scoreController, cardController);
    }

    /**
     * Lance la partie
     */
    public void start() {
        for (int i=0; i<3; i++) {
            roundController.doOneRound();
        }
    }

    public void addPlayer(IPlayer pl)    {
        playerController.addPlayer(pl);
    }
    public void removePlayer(IPlayer pl)    {
        playerController.removePlayer(pl);
    }
}

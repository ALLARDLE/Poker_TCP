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

public class PokerGameController implements Runnable {

    private final PokerPlayerController playerController;
    private final RoundController roundController;

    private final static int maxPlayers = 6;


    public PokerGameController(List<IPlayer> pls)  {
        playerController = new PokerPlayerController(pls);
        roundController = new RoundController(pls,
                new PokerMoneyController(pls, 10),
                new CardController(new PokerDeck()));
    }


    /**
     * Lance la partie
     */
    public void run() {
        while (playerController.getPlayers().size() >= 2)   {       // tant qu'il y a suffisamment de joueurs sur la table
            IPlayer winner = roundController.start();       // lance une manche
            System.out.print("Winner is ");
            System.out.println(winner);     // affiche le vainqueur
        }
    }

    /**
     * Ajoute un joueur à la partie
     * @param pl
     */
    public void addPlayer(IPlayer pl)    {
        playerController.addPlayer(pl);
    }

    /**
     * Supprime un joueur de la partie
     * @param pl
     */
    public void removePlayer(IPlayer pl)    {
        playerController.removePlayer(pl);
    }
}

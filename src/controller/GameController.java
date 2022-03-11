package controller;


/**
 * Joue le rôle du croupier :
 * Accepte les joueurs à la table, donne l'ordre de distribuer les cartes, prend en compte les mises, ...
 */
public class GameController {
    private IScoreController scoreController;
    private ICardController cardController;
    private PokerPlayerController playerController;
    private RoundController roundController;

    public GameController(IScoreController sc,
                          ICardController cc,
                          PokerPlayerController pc,
                          RoundController rc)  {
        scoreController = sc;
        cardController = cc;
        playerController = pc;
        roundController = rc;
    }

    /**
     * Vérifier la gestion des joueurs, ...
     */
    public void run()   {
        // Distribue les cartes,
    }
}

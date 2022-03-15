package controller;

import model.player.IPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RoundController {

    private final List<IPlayer> players;
    private final List<IPlayer> inGamePlayers;
    private IScoreController scoreController;
    private final ICardController cardController;
    private static int roundCount;

    private int indexDealer = 0;

    public RoundController(List<IPlayer> pls,
                           IScoreController sc,
                           ICardController cc)  {
        this.players = pls;
        this.inGamePlayers = new ArrayList<>();
        this.scoreController = sc;
        this.cardController = cc;
        resetRoundCount();
    }


    /**
     * Lance un tour d'enchère
     */
    private void startBet() {
        List<IPlayer> removePlayer = new ArrayList<>();     // liste des joueurs à supprimer à la fin du tour
        for (IPlayer player: inGamePlayers)    {        // parcourt tous les joueurs encore en jeu
            System.out.println(player);
            // int playerCommand = player.waitAction()      // attend action du joueur
            int retVal = menuBet(player);
            switch (retVal) {
                case 1 -> scoreController.bet(20, player);
                case 2 -> scoreController.raise(20, player);
                case 3 -> removePlayer.add(player);
            }
        }
        for (IPlayer player: removePlayer)  {       // suppression des joueurs qui se sont couchés
            inGamePlayers.remove(player);
        }
    }

    /**
     * Réinitialise la liste des joueurs en jeu
     */
    private void resetInGamePlayer()    {
        inGamePlayers.clear();
        setInGamePlayer();
    }

    /**
     * Initialise les joueurs qui vont jouer
     */
    private void setInGamePlayer()  {
        indexDealer = (indexDealer + 1) % players.size();       // déplace le Dealer d'une place
        for (int i=0; i<players.size(); i++) {
            // on tire les joueurs dans l'ordre (le dealer parle en dernier)
            inGamePlayers.add(players.get((i + indexDealer + 1) % players.size()));
        }
    }

    /**
     * Lance une manche
     * @return le vainqueur de la manche
     */
    public IPlayer start()  {
        resetRoundCount();      // réinitialise le compteur de tour
        resetInGamePlayer();        // réinitialise les joueurs en jeu
        setBlinds();        // initialise les blindes
        cardController.dealPlayerHand(inGamePlayers);       // distribue les cartes aux joueurs
        startBet();     // lance un tour d'enchère

        while(!isAWinner()) {       // tant qu'il n'y a pas de vainqueur
            distributeCard();
            startBet();
        }
        scoreController.
        return inGamePlayers.get(0);        // le dernier joueur en jeu est le vainqueur
    }

    /**
     * Réinitialise le tour de jeu
     */
    private static void resetRoundCount(){roundCount = 0;}

    /**
     * Distribue les cartes en fonction du tour de jeu
     */
    private void distributeCard()  {
        switch (roundCount) {
            case 0 ->   {
                cardController.dealFlop();
            }
            case 1 ->   {
                cardController.dealRiver();
            }
            case 2 -> {
                cardController.dealTurn();
            }
        }
        roundCount++;
    }

    /**
     * Menu de parie pour le joueur
     */
    private int menuBet(IPlayer player)   {
        Scanner input = new Scanner(System.in);
        System.out.println("Choix du joueur : ");
        System.out.println("1) Bet");
        System.out.println("2) Raise");
        System.out.println("3) Fold");
        System.out.print("--> ");
        int res = 0;
        try {
            res = input.nextInt();
            if (res > 3)  {
                res = menuBet(player);
            }
        } catch (Exception e)   {
            System.out.println("Not a integer");
            return menuBet(player);
        }
        return res;
    }


    /**
     * Définie les blindes et le dealer
     */
    private void setBlinds()  {
        for (int i=0; i<inGamePlayers.size(); i++)    {
            players.get(i).setDealer(false);
            players.get(i).setSmallBlind(false);
            players.get(i).setBigBlind(false);

            if (i==indexDealer) {
                players.get(i).setDealer(true);
            }
            else if(i==(indexDealer + 1) % players.size()) {
                players.get(i).setSmallBlind(true);
            }
            else if(i==(indexDealer + 2) % players.size()) {
                players.get(i).setBigBlind(true);
            }
        }
    }

    /**
     * Vérifie si il y a un vainqueur
     * @return
     */
    private boolean isAWinner()  {
        // TODO si plus qu'un joueur alors victoire sinon vérifier qu'on est au dernier tour et retourner le vainqueur
        // supprimer tous les joueurs de la liste sauf le vainqueur
        return inGamePlayers.size() == 1;
    }
}

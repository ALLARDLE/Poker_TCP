package controller;

import model.player.IPlayer;

import java.util.List;
import java.util.Scanner;


public class RoundController {

    private final List<IPlayer> players;
    private IScoreController scoreController;
    private final ICardController cardController;
    private static int roundCount;

    private int indexDealer = 0;

    public RoundController(List<IPlayer> pls,
                           IScoreController sc,
                           ICardController cc)  {
        this.players = pls;
        this.scoreController = sc;
        this.cardController = cc;
        resetRoundCount();
    }

    private static void resetRoundCount(){roundCount = 0;}

    /**
     * Lance un tour de manche
     * 0 --> distribue les cartes aux joueurs
     * 1 --> retourne les 3 premières cartes
     * 2 --> retourne la carte suivante
     * 3 --> retourne la carte suivante
     */
    public void doOneRound()   {
        if (roundCount == 0)    {
            setBlinds();
            cardController.dealPlayerHand(players);
        }
        else if(roundCount == 1) {
            cardController.dealFlop();
        }
        else if (roundCount == 2)   {
            cardController.dealRiver();
        }
        else if (roundCount == 3)   {
            cardController.dealTurn();
        }

        // action des joueurs ...
        for (int i=0; i<players.size(); i++)    {
            // switch/ case sur la réponse du joueur, tester si le joueur est toujours en jeu
            Scanner input = new Scanner(System.in);
            System.out.println(players.get((i + indexDealer) % players.size()));
            System.out.print("Choix du joueur : ");     // TODO lancer fonction de choix du joueur
            String res = input.nextLine();
            int retVal = 0;
            switch (retVal) {
                case 0:
                    System.out.println("Choix 0 (bet)");
                    break;
                case 1:
                    System.out.println("Choix 1 (raise)");
                    break;
                case 2:
                    System.out.println("Choix 2 (fold)");
                    break;
            }
        }

        roundCount++;
    }

    private void setBlinds()  {
        for (int i=0; i<players.size(); i++)    {
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
        scoreController.firstRound();       // place les mises pour les joueurs ayant des blindes
        indexDealer = (indexDealer + 1) % players.size();
    }
}

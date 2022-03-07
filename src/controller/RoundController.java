package controller;

import model.player.IPlayer;

import java.util.ArrayList;

public class RoundController {

    private final ArrayList<IPlayer> players;
    private IScoreController scoreController;
    private final ICardController cardController;
    private static int roundCount;

    public RoundController(ArrayList<IPlayer> pls,
                           IScoreController sc,
                           ICardController cc)  {
        this.players = pls;
        this.scoreController = sc;
        this.cardController = cc;
        resetRoundCount();
    }

    private static void resetRoundCount(){roundCount = 0;}

    public void run()   {
        roundCount++;

        if(roundCount == 1) {
            cardController.dealFlop();
        }
        else if (roundCount == 2)   {
            cardController.dealRiver();
        }
        else if (roundCount == 3)   {
            cardController.dealTurn();
        }
    }
}

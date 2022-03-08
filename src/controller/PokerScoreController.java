package controller;

import model.player.IPlayer;

import java.util.List;

public class PokerScoreController implements IScoreController {

    private List<IPlayer> players;
    private int smallBlind;
    private int bigBlind;
    private int pot = 0;
    private int call = 0;
    private int bet = 0;
    private int raise = 0;

    public PokerScoreController()   {

    }
    @Override
    public void run() {

    }

    @Override
    public void bet(int bet, IPlayer player) {

    }
}
